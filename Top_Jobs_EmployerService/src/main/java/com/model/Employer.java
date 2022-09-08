package com.model;

import javax.persistence.*;

@Entity
@Table(name = "employer")
public class Employer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String companyName;

    @Column(nullable=false, unique=true)
    private String password;

    @Column(nullable = false, length = 120, unique=true)
    private String email;

    @Column(nullable=false, length = 50, unique=true)
    private String employerId;

    @Column(nullable = false, length = 50)
    private String category;

    @Column(length = 250)
    private String about;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getEmployerId() {
        return employerId;
    }

    public void setEmployerId(String employerId) {
        this.employerId = employerId;
    }

    @Override
    public String toString() {
        return "Employer{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", employerId='" + employerId + '\'' +
                ", category='" + category + '\'' +
                ", about='" + about + '\'' +
                '}';
    }
}
