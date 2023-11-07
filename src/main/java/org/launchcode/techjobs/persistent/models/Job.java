package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Job extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "employer_id")
    private Employer employer;

//    @NotNull(message = "Job name cannot be blank")
//    @Size(min = 1, max = 60, message = "Job name must be between 1 and 60 characters in length")
//    private String name;

    @ManyToMany
    @JoinTable(
            name = "job_skills",
            joinColumns = @JoinColumn(name = "job_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )

    private List<Skill> skills;

    public Job() {

    }

    public Job(Employer anEmployer, List<Skill> someSkills) {
        super();
//        this.name = aName;
        this.employer = anEmployer;
        this.skills = (List<Skill>) someSkills;
    }

//    public String getName(){
//        return name;
//    }
//
//    public void setName(String name){
//        this.name = name;
//    }

    public Employer getEmployer(){
        return employer;
    }

    public void setEmployer(Employer employer){
        this.employer = employer;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }
//    public List<Skill> getSkills(){
//        return (Set<Skill>) skills;
//    }
//
//    public void setSkills(Set<Skill> skills){
//        this.skills = (List<Skill>) skills;
//    }

    public Iterable<Integer> getSkillIds() {
        return null;
    }
}