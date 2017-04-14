package com.sanmateo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by rsbulanon on 4/14/17.
 */
@Entity
public class AppUser {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "CHAR(36)", length = 36)
    private String id;

    @NotNull(message = "employee no. is required.")
    @Column(unique = true, nullable = false)
    @JsonProperty("employee_no")
    private String employeeNo;

    @Column
    @JsonProperty("first_name")
    @NotNull(message = "first name is required.")
    private String firstName;

    @Column
    @JsonProperty("last_name")
    @NotNull(message = "last name is required.")
    private String lastName;

    @Column
    @JsonProperty("middle_name")
    @NotNull(message = "middle name is required.")
    private String middleName;

    @Column
    @JsonProperty("address")
    @NotNull(message = "address is required.")
    private String address;

    @Column
    @JsonProperty("contact_no")
    @NotNull(message = "Contact no. is required")
    private String contactNo;

    @Column
    @JsonProperty("birth_date")
    @NotNull(message = "birth date is required.")
    private Date birthDate;

    @Column(unique = true, nullable = false)
    @NotNull(message = "email is required.")
    private String email;

    @Column(unique = true, nullable = false)
    @NotNull(message = "username is required.")
    private String username;

    @Column(columnDefinition = "CHAR(30)", length = 30)
    @NotNull(message = "role is required.")
    private String role;

    @Column
    @NotNull(message = "password is required.")
    private String password;

    @Column(columnDefinition = "CHAR(10)", length = 10)
    private String status;

    @Column
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

    @Column
    @JsonProperty("is_synced")
    private boolean isSynced;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public boolean isSynced() {
        return isSynced;
    }

    public void setSynced(boolean synced) {
        isSynced = synced;
    }
}
