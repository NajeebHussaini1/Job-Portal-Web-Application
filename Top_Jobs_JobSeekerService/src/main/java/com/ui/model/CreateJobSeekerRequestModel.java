package com.ui.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateJobSeekerRequestModel {

    @NotNull(message="first name cannot be null")
    @Size(min=2, message= "first name must not be less than two characters")
    private String firstName;

    @NotNull(message="last name cannot be null")
    @Size(min=2, message= "last name must not be less than two characters")
    private String lastName;

    @NotNull(message="Password cannot be null")
    @Size(min=8, max=16, message="Password must be equal or grater than 8 characters and less than 16 characters")
    private String password;

    @NotNull(message="Email cannot be null")
    @Email
    private String email;

    @NotNull(message="user name cannot be null")
    @Size(min=1, message= "user name must not be less than one characters")
    private String userName;

    private String gender;
    private String phoneNumber;

    @NotNull(message="city cannot be null")
    @Size(min=2, message= "first name must not be less than two characters")
    private String city;

    @NotNull(message="province cannot be null")
    @Size(min=2, max = 2, message= "first name must not be less than two characters")
    private String province;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
