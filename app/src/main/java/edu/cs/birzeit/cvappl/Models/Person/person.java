package edu.cs.birzeit.cvappl.Models.Person;

import java.io.Serializable;

public class person implements Serializable {
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String dateOfBirth;
    private String phoneNumber;
    private String isStudent;
    private String city;
    private String maritalStatus;
    private int freeTimePercentage;

    public person() {
    }

    public person(String firstName, String lastName, String email, String gender, String dateOfBirth, String phoneNumber, String isStudent, String city, String maritalStatus, int freeTimePercentage) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.isStudent = isStudent;
        this.city = city;
        this.maritalStatus = maritalStatus;
        this.freeTimePercentage = freeTimePercentage;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String isStudent() {
        return isStudent;
    }

    public void setStudent(String student) {
        isStudent = student;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public int getFreeTimePercentage() {
        return freeTimePercentage;
    }

    public void setFreeTimePercentage(int freeTimePercentage) {
        this.freeTimePercentage = freeTimePercentage;
    }
}
