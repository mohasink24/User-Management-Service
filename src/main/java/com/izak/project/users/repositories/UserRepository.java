package com.izak.project.users.repositories;

import com.izak.project.users.base.AuditedEntityRepository;
import com.izak.project.users.entities.User;
import org.springframework.stereotype.Repository;

/**
 * User Repository user database operations
 *
 * @author Mohasin Kazi
 * @since 1st March 2020
 */
@Repository
public interface UserRepository extends AuditedEntityRepository<User, Long> {

}
