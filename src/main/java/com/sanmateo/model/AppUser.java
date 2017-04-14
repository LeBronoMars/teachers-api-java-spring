package com.sanmateo.model;

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
@Data
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
}
