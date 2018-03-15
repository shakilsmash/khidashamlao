package org.shakilsmash.khidashamlao.service;

import org.shakilsmash.khidashamlao.model.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by shakilsmash on 3/10/2018.
 */
public interface RestaurantService {

    Restaurant save(Restaurant restaurant);

    Restaurant retrieve(long id);

    Page<Restaurant> retrieveAll(Pageable pageable);

    void delete(long id);

    void deletePermanently(long id);

}
