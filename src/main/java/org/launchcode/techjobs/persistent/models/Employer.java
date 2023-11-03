package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Employer extends AbstractEntity {

    @NotNull(message = "Location cannot be blank")
    @Size(min = 1, max = 60, message = "Location must be between 1 and 60 characters in length")
    private String location;

    public Employer() {
    }

    public Employer(String location) {
        this.location = location;
    }

    public String getLocation()

    {
        return location;
    }

    public

    void

    setLocation(String location)

    {
        this.location = location;
    }

}