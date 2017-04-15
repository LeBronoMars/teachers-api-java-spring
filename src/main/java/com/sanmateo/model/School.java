package com.sanmateo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

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

    @OneToOne
    @Fetch(value = FetchMode.JOIN)
    private AppUser principal;
}
