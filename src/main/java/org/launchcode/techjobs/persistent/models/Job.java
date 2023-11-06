package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Job extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @NotNull(message = "Job name cannot be blank")
    @Size(min = 1, max = 60, message = "Job name must be between 1 and 60 characters in length")
    private String name;

    @Size(min = 1, max = 60, message = "Skills must be between 1 and 60 characters in length")
    private String skills;

    public Job(){

    }

    public Job(String aName, Employer anEmployer, String someSkills) {
        super();
        this.name = aName;
        this.employer = anEmployer;
        this.skills = someSkills;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }
}