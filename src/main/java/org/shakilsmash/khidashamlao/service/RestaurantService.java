package org.shakilsmash.khidashamlao.service;

import org.shakilsmash.khidashamlao.model.Restaurant;

/**
 * Created by shakilsmash on 3/10/2018.
 */
public interface RestaurantService {

    Restaurant save(Restaurant restaurant);

    Restaurant retrieve(long id);

    Iterable<Restaurant> retrieveAll();

    void delete(long id);

    void deletePermanently(long id);

}
