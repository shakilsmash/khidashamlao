package org.shakilsmash.khidashamlao.service;

import org.shakilsmash.khidashamlao.domain.Sustenance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SustenanceService {

    /**
     * Saves a restaurant.
     *
     * @param sustenance is the id of the object that is to be saved
     * @return null
     */
    Sustenance save(Sustenance sustenance);

    /**
     * @param id is the id of the object that is to be returned
     * @return the sustenance object
     */
    Sustenance retrieve(long id);

    /**
     * @return all the sustenance objects available on the database
     */
    Page<Sustenance> retrieveAll(Pageable pageable);

    /**
     * Updates the sustenance status and deletion time but doesn't delete the entity from the database.
     * @return null
     */
    void delete(long id);

    /**
     * Deletes the sustenance entity from the database.
     * @return null
     */
    void deletePermanently(long id);

}
