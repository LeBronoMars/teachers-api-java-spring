package com.sanmateo.dto.school;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sanmateo.dto.user.AppUserDto;
import lombok.Data;

/**
 * Created by rsbulanon on 4/15/17.
 */
@Data
public class SchoolDto {

    private String id;

    @JsonProperty("school_name")
    private String schoolName;

    @JsonProperty("school_address")
    private String schoolAddress;

    @JsonProperty("contact_no")
    private String contactNo;

    @JsonProperty("email")
    private String email;

    private AppUserDto principal;
}
