package org.shakilsmash.khidashamlao.service;

import org.shakilsmash.khidashamlao.domain.Cuisine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by shakilsmash on 3/21/2018.
 */
public interface CuisineService {

    /**
     * Saves a cuisine.
     *
     * @param cuisine is the id of the object that is to be saved
     * @return null
     */
    Cuisine save(Cuisine cuisine);

    /**
     * @param id is the id of the object that is to be returned
     * @return the cuisine object
     */
    Cuisine retrieve(long id);

    /**
     * @return all the cuisine objects available on the database
     */
    Page<Cuisine> retrieveAll(Pageable pageable);

    /**
     * Updates the cuisine status and deletion time but doesn't delete the entity from the database.
     * @return null
     */
    void delete(long id);

    /**
     * Deletes the cuisine entity from the database.
     * @return null
     */
    void deletePermanently(long id);
    
}
