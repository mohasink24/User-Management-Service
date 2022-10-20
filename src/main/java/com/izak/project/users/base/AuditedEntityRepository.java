package com.izak.project.users.base;

import org.springframework.data.repository.Repository;

import java.io.Serializable;


public interface AuditedEntityRepository<T extends AuditedEntity, ID extends Serializable> extends Repository<T, ID> {

    T findById(Long uuid);

    T findByUuid(String uuid);

    T save(T auditedEntity);

    T delete(T auditedEntity);
}
