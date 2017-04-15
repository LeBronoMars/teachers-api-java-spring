package com.sanmateo.dto.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * Created by rsbulanon on 4/14/17.
 */
@Data
public class AppUserDto {

    private String id;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    @JsonProperty("created_at")
    private Date createdAt;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    @JsonProperty("updated_at")
    private Date updatedAt;

    private Boolean active;

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
