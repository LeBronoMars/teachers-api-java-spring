package com.sanmateo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by rsbulanon on 4/14/17.
 */
@Entity
public class AppUser extends BaseModel {

    @Column(unique = true, nullable = false)
    @JsonProperty("employee_no")
    private String employeeNo;

    @Column(nullable = false)
    @JsonProperty("first_name")
    private String firstName;

    @Column(nullable = false)
    @JsonProperty("last_name")
    private String lastName;

    @Column(nullable = false)
    @JsonProperty("middle_name")
    private String middleName;

    @Column(nullable = false)
    @JsonProperty("address")
    private String address;

    @Column(nullable = false)
    @JsonProperty("contact_no")
    private String contactNo;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonProperty("birth_date")
    @Column(name = "birth_date", nullable = false)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date birthDate;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(columnDefinition = "CHAR(30)", length = 30, nullable = false)
    private String role;

    @Column(nullable = false)
    private String password;

    @Column(columnDefinition = "CHAR(10)", length = 10, nullable = false)
    private String status;

    @Column(nullable = false)
    @JsonProperty("pic_url")
    private String picUrl;

    @Column(columnDefinition = "CHAR(50)", length = 50)
    @NotNull(message = "position is required.")
    private String position;

    @Column(columnDefinition = "CHAR(6)", length = 6)
    @NotNull(message = "gender is required.")
    private String gender;

    @Column(columnDefinition = "CHAR(10)", length = 10)
    @NotNull(message = "civil status is required.")
    @JsonProperty("civil_status")
    private String civilStatus;

    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
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

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCivilStatus() {
        return civilStatus;
    }

    public void setCivilStatus(String civilStatus) {
        this.civilStatus = civilStatus;
    }
}
