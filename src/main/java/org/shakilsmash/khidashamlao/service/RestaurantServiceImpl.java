package org.shakilsmash.khidashamlao.service;

import org.shakilsmash.khidashamlao.domain.Restaurant;
import org.shakilsmash.khidashamlao.domain.Status;
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
     * @inheritDoc
     */
    public Restaurant save(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    /**
     * @inheritDoc
     */
    public Restaurant retrieve(long id) {
        return restaurantRepository.findOne(id);
    }

    /**
     * @inheritDoc
     */
    public Page<Restaurant> retrieveAll(Pageable pageable) {
        return restaurantRepository.findAll(pageable);
    }

    /**
     * @inheritDoc
     */
    public void delete(long id) {
        Restaurant restaurant = restaurantRepository.findOne(id);
        restaurant.setStatus(Status.DELETED);
        restaurant.setDeletedAt(new Timestamp(new Date().getTime()));
        restaurantRepository.save(restaurant);
    }

    /**
     * @inheritDoc
     */
    public void deletePermanently(long id) {
        restaurantRepository.delete(id);
    }
}
