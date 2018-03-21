package org.shakilsmash.khidashamlao.service;

import org.shakilsmash.khidashamlao.domain.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by shakilsmash on 3/10/2018.
 */
public interface RestaurantService {

    /**
     * Saves a restaurant.
     *
     * @param restaurant is the id of the object that is to be saved
     * @return null
     */
    Restaurant save(Restaurant restaurant);

    /**
     * @param id is the id of the object that is to be returned
     * @return the restaurant object
     */
    Restaurant retrieve(long id);

    /**
     * @return all the restaurant objects available on the database
     */
    Page<Restaurant> retrieveAll(Pageable pageable);

    /**
     * Updates the restaurant status and deletion time but doesn't delete the entity from the database.
     * @return null
     */
    void delete(long id);

    /**
     * Deletes the restaurant entity from the database.
     * @return null
     */
    void deletePermanently(long id);

}
