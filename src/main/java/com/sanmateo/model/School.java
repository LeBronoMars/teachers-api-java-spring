package com.sanmateo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by rsbulanon on 4/14/17.
 */
@Data
@Entity
public class School extends BaseModel {

    @JsonProperty("school_name")
    @Column(unique = true, nullable = false)
    private String schoolName;

    @JsonProperty("school_address")
    @Column(unique = true, nullable = false)
    private String schoolAddress;

    @Column(nullable = false)
    @JsonProperty("contact_no")
    private String contactNo;

    @Column(nullable = false)
    @JsonProperty("email")
    private String email;

    @Column(nullable = false)
    @JsonProperty("latitude")
    private double latitude;

    @Column(nullable = false)
    @JsonProperty("longitude")
    private double longitude;
}
