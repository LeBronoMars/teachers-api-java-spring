package com.sanmateo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

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
    @ApiModelProperty(example = "EMP-00001")
    private String employeeNo;

    @Column(nullable = false)
    @JsonProperty("first_name")
    @ApiModelProperty(example = "Ned")
    private String firstName;

    @Column(nullable = false)
    @JsonProperty("last_name")
    @ApiModelProperty(example = "Johnson")
    private String lastName;

    @Column(nullable = false)
    @JsonProperty("middle_name")
    @ApiModelProperty(example = "Flanders")
    private String middleName;

    @Column(nullable = false)
    @JsonProperty("address")
    @ApiModelProperty(example = "Hagonoy, Bulacan")
    private String address;

    @Column(nullable = false)
    @JsonProperty("contact_no")
    @ApiModelProperty(example = "09123456789")
    private String contactNo;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonProperty("birth_date")
    @Column(name = "birth_date", nullable = false)
    @JsonFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(example = "1988-09-25")
    private Date birthDate;

    @Column(unique = true, nullable = false)
    @ApiModelProperty(example = "ned@flanders.com")
    private String email;

    @Column(unique = true, nullable = false)
    @ApiModelProperty(example = "nedflanders")
    private String username;

    @Column(columnDefinition = "CHAR(30)", length = 30, nullable = false)
    @ApiModelProperty(example = "SUPER_ADMIN")
    private String role;

    @Column(nullable = false)
    @ApiModelProperty(example = "P@ssw0rd")
    private String password;

    @Column(columnDefinition = "CHAR(10)", length = 10, nullable = false)
    private String status;

    @Column(nullable = false)
    @JsonProperty("pic_url")
    private String picUrl;

    @Column(columnDefinition = "CHAR(50)", length = 50)
    @NotNull(message = "position is required.")
    @ApiModelProperty(example = "SUPER_ADMIN")
    private String position;

    @Column(columnDefinition = "CHAR(6)", length = 6)
    @NotNull(message = "gender is required.")
    @ApiModelProperty(example = "Male")
    private String gender;

    @Column(columnDefinition = "CHAR(10)", length = 10)
    @NotNull(message = "civil status is required.")
    @JsonProperty("civil_status")
    @ApiModelProperty(example = "Single")
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
