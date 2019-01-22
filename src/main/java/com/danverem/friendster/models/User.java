package com.danverem.friendster.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users")
@NamedQueries({
    @NamedQuery( name = User.FIND_BY_USERNAME, query = "SELECT u FROM User u WHERE u.username = :username"),
    @NamedQuery(name = User.SEARCH, query = "SELECT u FROM User u WHERE u.username LIKE :param OR u.emailAddress LIKE :param OR u.firstName LIKE :param OR u.lastName LIKE :param")
})
public class User {

    public static final String FIND_BY_USERNAME = "User.findByUsername";
    public static final String SEARCH = "user.findByAllAttributes";

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long ID;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email_address")
    private String emailAddress;
    @Column(name = "password")
    private String password;
    @Column(name = "username")
    private String username;


    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
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

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getID(), user.getID()) &&
            Objects.equals(getFirstName(), user.getFirstName()) &&
            Objects.equals(getLastName(), user.getLastName()) &&
            Objects.equals(getEmailAddress(), user.getEmailAddress()) &&
            Objects.equals(getPassword(), user.getPassword()) &&
            Objects.equals(getUsername(), user.getUsername());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getID(), getFirstName(), getLastName(), getEmailAddress(), getPassword(), getUsername());
    }

    @Override
    public String toString() {
        return "User{" +
            "ID=" + ID +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", emailAddress='" + emailAddress + '\'' +
            ", password='" + password + '\'' +
            ", username='" + username + '\'' +
            '}';
    }
}
