package com.sanmateo.dto.school;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by rsbulanon on 4/15/17.
 */
@Data
public class SchoolRegistrationDto {

    @JsonProperty("school_name")
    @ApiModelProperty(example = "San Mateo National High School")
    private String schoolName;

    @JsonProperty("school_address")
    @ApiModelProperty(example = "San Mateo, Rizal")
    private String schoolAddress;

    @ApiModelProperty(example = "09151234567")
    @JsonProperty("contact_no")
    private String contactNo;

    @ApiModelProperty(example = "sample@gmail.com")
    @JsonProperty("email")
    private String email;

    @JsonProperty("principal_user_id")
    private String principal;
}
