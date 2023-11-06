package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Employer extends AbstractEntity{
    @JoinColumn(name = "employer_id", referencedColumnName = "id")
    @OneToMany(mappedBy = "employer")
    private List<Job> jobs = new ArrayList<>();

    @NotNull(message = "Location cannot be blank")
    @Size(min = 1, max = 60, message = "Location must be between 1 and 60 characters in length")
    private String location;

    public Employer(){

    }

    public Employer(String location) {
        this.location = location;
    }

    public String getLocation(){
        return location;
    }

    public void setLocation(String location){
        this.location = location;
    }

    public List<Job> getJobs(){
        return jobs;
    }

    public void setJobs(List<Job> jobs){
        this.jobs = jobs;
    }
}