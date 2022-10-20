package com.izak.project.users.base;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Base entity structure
 *
 * @author Mohasin Kazi
 * @since 1st March 2020
 */
@MappedSuperclass
@Data
public abstract class AuditedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    @Access(AccessType.FIELD)
    private long id;

    @Column(name = "uuid", updatable = false, length = 100, nullable = false, unique = true)
    private String uuid;

    @CreationTimestamp
    @Column(name = "create_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


    /**
     * Constructor
     */
    public AuditedEntity() {
        // Init
    }
}
