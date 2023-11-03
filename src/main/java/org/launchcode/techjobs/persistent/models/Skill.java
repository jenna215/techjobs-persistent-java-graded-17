package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Skill extends AbstractEntity {

    private String description;

    public Skill() {
    }

    public Skill(String description)

    {
        this.description = description;
    }

    public String getDescription()

    {
        return description;
    }

    public

    void

    setDescription(String description)

    {
        this.description = description;
    }

}