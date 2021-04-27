package edu.cs.birzeit.cvappl.Models.Work;

public class work {
    private String jobTitle;
    private String jobAddress;
    private String companyName;
    private double salary;
    private String otherJobs;

    public work() {
    }


    public work(String jobTitle, String jobAddress, String companyName, double salary, String otherJobs) {
        this.jobTitle = jobTitle;
        this.jobAddress = jobAddress;
        this.companyName = companyName;
        this.salary = salary;
        this.otherJobs = otherJobs;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobAddress() {
        return jobAddress;
    }

    public void setJobAddress(String jobAddress) {
        this.jobAddress = jobAddress;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getOtherJobs() {
        return otherJobs;
    }

    public void setOtherJobs(String otherJobs) {
        this.otherJobs = otherJobs;
    }
}
