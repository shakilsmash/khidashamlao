package org.shakilsmash.khidashamlao.service;

import org.shakilsmash.khidashamlao.model.Restaurant;
import org.shakilsmash.khidashamlao.model.Status;
import org.shakilsmash.khidashamlao.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class RestaurantServiceImpl implements RestaurantService{


    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    /**
     * Saves a restaurant.
     *
     * @param restaurant is the id of the object that is to be saved
     * @return null
     */
    public Restaurant save(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    /**
     * @param id is the id of the object that is to be returned
     * @return the restaurant object
     */
    public Restaurant retrieve(long id) {
        return restaurantRepository.findOne(id);
    }

    /**
     * @return all the restaurant objects available on the database
     */
    public Page<Restaurant> retrieveAll(Pageable pageable) {
        return restaurantRepository.findAll(pageable);
    }

    /**
     * Updates the restaurant status and deletion time but doesn't delete the entity from the database.
     * @return null
     */
    public void delete(long id) {
        Restaurant restaurant = restaurantRepository.findOne(id);
        restaurant.setStatus(Status.DELETED);
        restaurant.setDeletedAt(new Timestamp(new Date().getTime()));
        restaurantRepository.save(restaurant);
    }

    /**
     * Deletes the restaurant entity from the database.
     * @return null
     */
    public void deletePermanently(long id) {
        restaurantRepository.delete(id);
    }
}
