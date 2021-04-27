package edu.cs.birzeit.cvappl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Objects;

import edu.cs.birzeit.cvappl.Models.Education.education;
import edu.cs.birzeit.cvappl.Models.Info.Info;
import edu.cs.birzeit.cvappl.Models.Person.person;
import edu.cs.birzeit.cvappl.Models.Work.work;

public class MainActivity2 extends AppCompatActivity {
    private Spinner degree;
    private EditText universityName;
    private EditText specialization;
    private EditText specializationRate;
    EditText jobTitle;
    private EditText jobAddress;
    private EditText companyName;
    private EditText salary;
    private EditText otherJobs;
    person person = new person();
    public education edu = new education();
    work job = new work();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setupViews2();




//Get Personal data from Avtivity 1
        Intent intent = getIntent();
        person=(person)intent.getSerializableExtra("personalData");

//Retrieve a data from the shared pref obj
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        Gson gson = new Gson();
        String str = prefs.getString("data", "");
        Info info = gson.fromJson(str, Info.class);

        if(info != null){
        retrieveData(info);

        }

    }

    private void setupViews2() {
        degree = findViewById(R.id.degree);
        populateDegree();

        universityName = findViewById(R.id.universityName);
        specialization = findViewById(R.id.specialization);
        specializationRate = findViewById(R.id.specializationRate);
        jobTitle = findViewById(R.id.jobTitle);
        jobAddress = findViewById(R.id.jobAddress);
        companyName = findViewById(R.id.companyName);
        salary = findViewById(R.id.salary);
        otherJobs = findViewById(R.id.otherJobs);

    }

    private void populateDegree() {
        ArrayList<String> degreeData = new ArrayList<>();
        degreeData.add("Bachelor");
        degreeData.add("Master");
        degreeData.add("Doctorate");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, degreeData);

        degree.setAdapter(adapter);
    }


    public void submitOnClick(View view) {
//Save Education Data
        edu.setDegree(degree.getSelectedItem().toString());
        edu.setUniversity(universityName.getText().toString());
        edu.setSpecialization(specialization.getText().toString());
        edu.setSpecializationRate(Double.parseDouble(specializationRate.getText().toString()));


//Save Job Data

        job.setJobTitle(jobTitle.getText().toString());
        job.setJobAddress(jobAddress.getText().toString());
        job.setCompanyName(companyName.getText().toString());
        job.setSalary(Double.parseDouble(salary.getText().toString()));
        job.setOtherJobs(otherJobs.getText().toString());


//Collect All Data in one Info Object
        Info info = new Info(person,job,edu);

//Save all Data in a Shared Perference

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String DataString = gson.toJson(info);

        editor.putString("data", DataString);
        editor.commit();
        Toast.makeText(this, "Data Saved:\n" ,
                Toast.LENGTH_SHORT).show();

    }


    public void retrieveData(Info info) {
//Fill education and work data in their correct places
        for(int i=0 ; i<degree.getAdapter().getCount() ;i++){
            if(Objects.equals(info.getEducation().getDegree(),degree.getAdapter().getItem(i))) {
                degree.setSelection(i);
            }
        }

        universityName.setText(info.getEducation().getUniversity());
        specialization.setText(info.getEducation().getSpecialization());
        specializationRate.setText(info.getEducation().getSpecializationRate()+"");

        jobTitle.setText(info.getWork().getJobTitle());
        jobAddress.setText(info.getWork().getJobAddress());
        companyName.setText(info.getWork().getCompanyName());
        salary.setText(info.getWork().getSalary()+"");
        otherJobs.setText(info.getWork().getOtherJobs());


    }
    public void exitOnClick(View view) {
        finishAffinity();
        System.exit(0);

    }

    public void deleteOnClick(View view) {
        degree.setSelected(false);
        universityName.setText("");
        specialization.setText("");
        specializationRate.setText("");
        jobTitle.setText("");
        jobAddress.setText("");
        companyName.setText("");
        salary.setText("");
        otherJobs.setText("");

    }
}
