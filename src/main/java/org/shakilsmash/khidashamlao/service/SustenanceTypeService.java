package org.shakilsmash.khidashamlao.service;

import org.shakilsmash.khidashamlao.domain.SustenanceType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by shakilsmash on 3/21/2018.
 */
public interface SustenanceTypeService {

    /**
     * Saves a sustenanceType.
     *
     * @param sustenanceType is the id of the object that is to be saved
     * @return null
     */
    SustenanceType save(SustenanceType sustenanceType);

    /**
     * @param id is the id of the object that is to be returned
     * @return the sustenanceType object
     */
    SustenanceType retrieve(long id);

    /**
     * @return all the sustenanceType objects available on the database
     */
    Page<SustenanceType> retrieveAll(Pageable pageable);

    /**
     * Updates the sustenanceType status and deletion time but doesn't delete the entity from the database.
     * @return null
     */
    void delete(long id);

    /**
     * Deletes the sustenanceType entity from the database.
     * @return null
     */
    void deletePermanently(long id);
    
}
