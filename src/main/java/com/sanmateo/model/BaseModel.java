package com.sanmateo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss'Z'")
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss'Z'")
    @Column(name = "updated", nullable = false)
    private Date updated;

    @Column
    private Boolean active;

    @Column
    @JsonProperty("is_synced")
    private boolean isSynced;

    @PrePersist
    protected void onCreate() {
        updated = created = new Date();
        active = true;
        isSynced = true;
    }

    @PreUpdate
    protected void onUpdate() {
        updated = new Date();
    }
}
