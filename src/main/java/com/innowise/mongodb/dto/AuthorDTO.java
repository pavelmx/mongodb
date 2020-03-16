package com.innowise.mongodb.dto;

import javax.validation.constraints.NotNull;

public class AuthorDTO {

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    public AuthorDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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

    public String getName() {
        return getFirstName() + " " + getLastName();
    }
}
