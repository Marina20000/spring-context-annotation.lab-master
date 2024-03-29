package org.shop.repository.map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.log4j.Logger;
import org.shop.data.Entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The Abstract Map Based Repository.
 *
 * @param <T> the generic type
 * @author Dzmitry_Naskou
 * 
 * @see Map
 */

public class AbstractMapRepository<T extends Entity> {
    private static final Logger logger = Logger.getLogger(AbstractMapRepository.class);
    
    /** The sequence. */
    protected long sequence = 0;
    
    protected final Map<Long, T> register = new HashMap<Long, T>();
    
    /**
     * Instantiates a new map based repository.
     */
    public AbstractMapRepository() {
        this(0);
    }

    /**
     * Instantiates a new map based repository.
     *
     * @param initialSequence the initial sequence value
     */
    public AbstractMapRepository(long initialSequence) {
        super();
        this.sequence = initialSequence;
    }

    /**
     * Get next primary key.
     *
     * @return the long
     */
    protected final Long nextPk() {
        return ++sequence;
    }
    
    /**
     * Gets the object by id.
     *
     * @param id the id
     * @return the object
     */
    protected T get(Long id) {
        return register.get(id);
    }
    
    /**
     * Save object to datasource.
     *
     * @param entity the entity
     * @return the object id
     */
    protected Long create(T entity) {
        Long id = nextPk();
        
        entity.setId(id);
        logger.info("entity="+entity.toString());
        register.put(id, entity);
        
        return id;
    }
    
    /**
     * Update the entity.
     *
     * @param entity the entity
     */
    protected void update(T entity) {
        if (entity.getId() != null) {
            register.put(entity.getId(), entity);
        }
    }
    
    /**
     * Delete the object by id.
     *
     * @param id the id
     */
    protected void delete(Long id) {
        register.remove(id);
    }
    
    /**
     * Select objects by predicate.
     *
     * @param predicate the predicate
     * @return the list
     * 
     * @see Predicate
     */
    @SuppressWarnings("unchecked")
    protected List<T> select(Predicate predicate) {
        logger.info("register.values()="+register.values());
        return (List<T>)CollectionUtils.select(register.values(), predicate);
    }
}
