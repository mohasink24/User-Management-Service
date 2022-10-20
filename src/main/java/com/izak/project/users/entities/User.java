package com.izak.project.users.entities;

import com.izak.project.users.base.AuditedEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;


/**
 * User entity class definition
 *
 * @author Mohasin Kazi
 * @since 1st March 2020
 */
@Entity
@Table(name = "user",
        indexes = {
                @Index(columnList = "uuid", unique = true, name = "uuid_unique_index")
        })
@Data
public class User extends AuditedEntity {


    @Column(name = "firstName", length = 50, nullable = false)
    private String firstName;

    @Column(name = "MiddleName", length = 50, nullable = false)
    private String middleName;

    @Column(name = "lastName", length = 50, nullable = false)
    private String lastName;

    @Column(name = "email", length = 150, nullable = false)
    private String email;

    @Column(name = "mobileNo", length = 12, nullable = false)
    private String mobileNo;

    @Column(name = "countryCode", length = 5, nullable = false)
    private String countryCode;

    @Column(name = "address", length = 200, nullable = false)
    private String address;


}
