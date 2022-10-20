package com.izak.project.users.service;

import com.izak.project.users.base.AuditedEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * Generic Database service implementations
 *
 * @author Mohasin Kazi
 * @since 1st March 2020
 */
@Service
public class GenericDatabaseServiceImpl<T extends AuditedEntity> implements DatabaseService<T> {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @Transactional(rollbackOn = Throwable.class)
    public T save(T entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    @Transactional(rollbackOn = Throwable.class)
    public T update(T entity) {
        return entityManager.merge(entity);
    }

    @Override
    @Transactional(rollbackOn = Throwable.class)
    public void delete(T entity) {
        entityManager.remove(entity);
    }

}
