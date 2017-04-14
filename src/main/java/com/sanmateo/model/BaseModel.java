package com.sanmateo.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Base implementation of model classes
 *
 * Created by rsbulanon on 4/14/17.
 */
@Data
@MappedSuperclass
public abstract class BaseModel implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "CHAR(36)", length = 36)
    protected String id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created", nullable = false)
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated", nullable = false)
    private Date updated;

    @Column
    private Boolean active;

    @PrePersist
    protected void onCreate() {
        updated = created = new Date();
        active = true;
    }

    @PreUpdate
    protected void onUpdate() {
        updated = new Date();
    }
}
