package org.shakilsmash.khidashamlao.repository;

import org.springframework.data.repository.CrudRepository;

import org.shakilsmash.khidashamlao.model.Restaurant;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {

}