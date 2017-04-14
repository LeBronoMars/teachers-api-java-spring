package com.sanmateo.dto;

import lombok.Data;

import java.util.Date;

/**
 * Created by rsbulanon on 4/14/17.
 */
@Data
public class AppUserDto {
    private String id;
    private String employeeNo;
    private String firstName;
    private String lastName;
    private String middleName;
    private String address;
    private String contactNo;
    private Date birthDate;
    private String email;
    private String username;
    private String role;
    private String status;
    private String picUrl;
    private String position;
    private String gender;
    private String civilStatus;
    private boolean isSynced;
}
