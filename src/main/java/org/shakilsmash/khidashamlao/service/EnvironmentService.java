package org.shakilsmash.khidashamlao.service;

import org.shakilsmash.khidashamlao.domain.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by shakilsmash on 3/21/2018.
 */
public interface EnvironmentService {

    /**
     * Saves a environment.
     *
     * @param environment is the id of the object that is to be saved
     * @return null
     */
    Environment save(Environment environment);

    /**
     * @param id is the id of the object that is to be returned
     * @return the environment object
     */
    Environment retrieve(long id);

    /**
     * @return all the environment objects available on the database
     */
    Page<Environment> retrieveAll(Pageable pageable);

    /**
     * Updates the environment status and deletion time but doesn't delete the entity from the database.
     * @return null
     */
    void delete(long id);

    /**
     * Deletes the environment entity from the database.
     * @return null
     */
    void deletePermanently(long id);
    
}
