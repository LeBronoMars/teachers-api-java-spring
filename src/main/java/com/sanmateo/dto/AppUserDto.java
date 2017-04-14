package com.sanmateo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

/**
 * Created by rsbulanon on 4/14/17.
 */
@Data
public class AppUserDto {

    private String id;

    @JsonProperty("employee_no")
    private String employeeNo;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("middle_name")
    private String middleName;

    private String address;

    @JsonProperty("contact_no")
    private String contactNo;

    @JsonProperty("birth_date")
    private Date birthDate;

    private String email;
    private String username;
    private String role;
    private String status;

    @JsonProperty("pic_url")
    private String picUrl;
    private String position;
    private String gender;

    @JsonProperty("civil_status")
    private String civilStatus;

    @JsonProperty("is_synced")
    private boolean isSynced;
}
