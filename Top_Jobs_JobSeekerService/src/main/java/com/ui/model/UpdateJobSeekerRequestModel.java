package com.ui.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class UpdateJobSeekerRequestModel {

    @NotNull(message="ID cannot be null")
    private Integer id;

    @NotNull(message="Email cannot be null")
    @Email
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
