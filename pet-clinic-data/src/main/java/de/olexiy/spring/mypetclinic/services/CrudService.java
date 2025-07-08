package de.olexiy.spring.mypetclinic.services;

import java.util.Set;

/**
 * Generic CRUD service interface providing common data access operations.
 * 
 * @param <T> the entity type
 * @param <ID> the entity ID type
 * @author Olexiy Sokurenko
 * @since 2018
 */
public interface CrudService<T, ID> {

    /**
     * Retrieves all entities.
     */
    Set<T> findAll();

    /**
     * Retrieves an entity by its ID.
     */
    T findById(ID id);

    /**
     * Saves a given entity.
     */
    T save(T entity);

    /**
     * Deletes a given entity.
     */
    void delete(T entity);

    /**
     * Deletes the entity with the given ID.
     */
    void deleteById(ID id);
}