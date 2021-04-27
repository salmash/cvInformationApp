package edu.cs.birzeit.cvappl.Models.Education;

public class education {
    private String degree;
    private String university;
    private String specialization;
    private double specializationRate;

    public education() {
    }

    public education(String degree, String university, String specialization, double specializationRate) {
        this.degree = degree;
        this.university = university;
        this.specialization = specialization;
        this.specializationRate = specializationRate;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public double getSpecializationRate() {
        return specializationRate;
    }

    public void setSpecializationRate(double specializationRate) {
        this.specializationRate = specializationRate;
    }
}
