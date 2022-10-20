package com.izak.project.users.service;

import com.izak.project.users.base.AuditedEntity;

import javax.transaction.Transactional;


/**
 * Generic database service (DAO)
 *
 * @param <T>
 * @author Mohasin Kazi
 * @since 1st March 2020
 */
public interface DatabaseService<T extends AuditedEntity> {
    T save(T entity);

    @Transactional(rollbackOn = Throwable.class)
    T update(T entity);

    @Transactional(rollbackOn = Throwable.class)
    void delete(T entity);
}
