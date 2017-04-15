package com.sanmateo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sanmateo.enums.UserRole;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by rsbulanon on 4/14/17.
 */
@Data
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
    @Enumerated(EnumType.STRING)
    private UserRole role;

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
    @ApiModelProperty(example = "Master Teacher 1")
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
}
