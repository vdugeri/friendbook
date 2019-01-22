package com.danverem.friendster.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class UserDTO implements Serializable {

    private Long ID;
    private String username;
    @JsonProperty("first_name")
    private String firstName;
    private String password;
    @JsonProperty("email_address")
    private String emailAddress;
    @JsonProperty("last_name")
    private String lastName;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
            "ID=" + ID +
            ", username='" + username + '\'' +
            ", firstName='" + firstName + '\'' +
            ", password='" + password + '\'' +
            ", emailAddress='" + emailAddress + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
    }
}
