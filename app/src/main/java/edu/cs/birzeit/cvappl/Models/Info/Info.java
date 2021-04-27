package edu.cs.birzeit.cvappl.Models.Info;

import java.io.Serializable;

import edu.cs.birzeit.cvappl.Models.Education.education;
import edu.cs.birzeit.cvappl.Models.Person.person;
import edu.cs.birzeit.cvappl.Models.Work.work;

public class Info implements Serializable {
    private person person ;
    private work work ;
    private education education ;


    public Info() {
    }

    public Info(person person, work work,  education education) {
        this.person = person;
        this.work = work;
        this.education = education;
    }

    public person getPerson() {
        return person;
    }

    public void setPerson(person person) {
        this.person = person;
    }

    public work getWork() {
        return work;
    }

    public void setWork(work work) {
        this.work = work;
    }

    public education getEducation() {
        return education;
    }

    public void setEducation(education education) {
        this.education = education;
    }
}
