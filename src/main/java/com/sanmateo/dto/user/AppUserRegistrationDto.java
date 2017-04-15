package com.sanmateo.dto.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * Created by rsbulanon on 4/15/17.
 */
@Data
public class AppUserRegistrationDto {

    @JsonProperty("employee_no")
    @ApiModelProperty(example = "EMP-00001")
    private String employeeNo;

    @JsonProperty("first_name")
    @ApiModelProperty(example = "Ned")
    private String firstName;

    @JsonProperty("last_name")
    @ApiModelProperty(example = "Johnson")
    private String lastName;

    @JsonProperty("middle_name")
    @ApiModelProperty(example = "Flanders")
    private String middleName;

    @JsonProperty("address")
    @ApiModelProperty(example = "Hagonoy, Bulacan")
    private String address;

    @JsonProperty("contact_no")
    @ApiModelProperty(example = "09123456789")
    private String contactNo;

    @JsonProperty("birth_date")
    @JsonFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(example = "1988-09-25")
    private Date birthDate;

    @ApiModelProperty(example = "ned@flanders.com")
    private String email;

    @ApiModelProperty(example = "nedflanders")
    private String username;

    @ApiModelProperty(example = "SUPER_ADMIN", allowableValues = "REGULAR_USER, ADMIN, SUPER_ADMIN")
    private String role;

    @ApiModelProperty(example = "P@ssw0rd")
    private String password;

    @ApiModelProperty(example = "SUPER_ADMIN")
    private String position;

    @ApiModelProperty(example = "Male", allowableValues = "Male, Female")
    private String gender;

    @JsonProperty("civil_status")
    @ApiModelProperty(example = "Single")
    private String civilStatus;
}
