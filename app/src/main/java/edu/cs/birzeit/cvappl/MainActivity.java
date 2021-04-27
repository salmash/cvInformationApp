package edu.cs.birzeit.cvappl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import edu.cs.birzeit.cvappl.MainActivity2;

import com.google.gson.Gson;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

import edu.cs.birzeit.cvappl.Models.Info.Info;
import edu.cs.birzeit.cvappl.Models.Person.person;
import edu.cs.birzeit.cvappl.MainActivity2;
public class MainActivity extends AppCompatActivity {
    EditText firstName;
    EditText lastName;
    EditText email;
    CheckBox male;
    CheckBox female;
    EditText dateOfBirth;
    EditText phoneNumber;
    Switch isStudent;
    Spinner cities;
    Spinner maritalStatus;
    TextView perc;
    ProgressBar progressBar;
    SeekBar seekBar;
    int per;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        Gson gson = new Gson();
        String str = prefs.getString("data", "");
        Info info = gson.fromJson(str, Info.class);

        if(info != null){
           retrieveData(info);
        }

    }


    private void setupViews() {
        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        email = findViewById(R.id.email);
        male = (CheckBox) findViewById(R.id.male);
        female = (CheckBox) findViewById(R.id.female);

        dateOfBirth = findViewById(R.id.dateOfBirth);
        phoneNumber = findViewById(R.id.phoneNumber);
        isStudent = findViewById(R.id.isStudent);
        cities = findViewById(R.id.cities);
        populateCities();
        maritalStatus = findViewById(R.id.maritalStatus);
        populateMaritalStatus();


        perc = (TextView) findViewById(R.id.perc);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        seekBar = (SeekBar) findViewById(R.id.seekBar);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressBar.setProgress(progress);
                perc.setText("" + progress + "%");
                per=progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



    }

    private void populateCities() {
        ArrayList<String> citiesData = new ArrayList<>();
        citiesData.add("Ramallah");
        citiesData.add("Bethlehem");
        citiesData.add("Hebron");
        citiesData.add("Qalqilya");
        citiesData.add("Jerusalem");
        citiesData.add("Nablus");
        citiesData.add("Salfit");
        citiesData.add("Jericho");
        citiesData.add("Tulkarm");
        citiesData.add("Jenin");


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, citiesData);

        cities.setAdapter(adapter);
    }

    private void populateMaritalStatus() {
        ArrayList<String> maritalStatusData = new ArrayList<>();
        maritalStatusData.add("Married");
        maritalStatusData.add("Engaged");
        maritalStatusData.add("Single");
        maritalStatusData.add("Widowed");
        maritalStatusData.add("Divorced");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, maritalStatusData);

        maritalStatus.setAdapter(adapter);
    }



    public void btnOnClick(View view) {

//Save Personal Data
        person person = new person();
        person.setFirstName(firstName.getText().toString());
        person.setLastName(lastName.getText().toString());
        person.setEmail(email.getText().toString());

        if (male.isChecked())
            person.setGender("Male");
        if (female.isChecked())
            person.setGender("Female");


        person.setDateOfBirth(dateOfBirth.getText().toString());
        person.setPhoneNumber(phoneNumber.getText().toString());

        if (isStudent.isChecked())
            person.setStudent("Student");
        else
            person.setStudent("Not a Student");


        person.setCity(cities.getSelectedItem().toString());
        person.setMaritalStatus(maritalStatus.getSelectedItem().toString());

        person.setFreeTimePercentage(per);


//Send Personal Data to Activity2
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtra("personalData",person);
        startActivity(intent);

    }


    public void retrieveData(Info info) {
//Fill All personal data in their correct places
        firstName.setText(info.getPerson().getFirstName());
        lastName.setText(info.getPerson().getLastName());
        email.setText(info.getPerson().getEmail());
        if (Objects.equals(info.getPerson().getGender(),"Male"))
            male.setChecked(true);

        if (Objects.equals(info.getPerson().getGender(),"Female"))
            female.setChecked(true);


        dateOfBirth.setText(info.getPerson().getDateOfBirth());
        phoneNumber.setText(info.getPerson().getPhoneNumber());

        if (Objects.equals(info.getPerson().isStudent(),"Student"))
            isStudent.setChecked(true);

        if (Objects.equals(info.getPerson().isStudent(), "Not a Student"))
            isStudent.setChecked(false);

        for(int i=0 ; i<cities.getAdapter().getCount() ;i++){
            if(Objects.equals(info.getPerson().getCity(),cities.getAdapter().getItem(i))) {
                cities.setSelection(i);
            }
        }

        for(int i=0 ; i<maritalStatus.getAdapter().getCount() ;i++){
            if(Objects.equals(info.getPerson().getMaritalStatus(),maritalStatus.getAdapter().getItem(i))) {
                maritalStatus.setSelection(i);
            }
        }

        perc.setText(info.getPerson().getFreeTimePercentage() + "%");
    }

    public void deleteOnClick(View view) {
        firstName.setText("");
        lastName.setText("");
        email.setText("");
        male.setChecked(false);
        female.setChecked(false);
        dateOfBirth.setText("");
        phoneNumber.setText("");
        isStudent.setChecked(false);
        cities.setSelected(false);
        maritalStatus.setSelected(false);
        perc.setText("0%");
        seekBar.setProgress(0);
        progressBar.setProgress(0);

    }

}