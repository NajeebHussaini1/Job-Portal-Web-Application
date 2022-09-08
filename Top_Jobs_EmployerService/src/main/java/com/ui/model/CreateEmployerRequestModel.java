package com.ui.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateEmployerRequestModel {

    @NotNull(message="Company name cannot be null")
    @Size(min=1, message= "Company name must not be less than two characters")
    private String companyName;

    @NotNull(message="Password cannot be null")
    @Size(min=8, max=16, message="Password must be equal or grater than 8 characters and less than 16 characters")
    private String password;

    @NotNull(message="Email cannot be null")
    @Email
    private String email;

    @NotNull(message="Category cannot be null")
    private String category;

    private String about;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
