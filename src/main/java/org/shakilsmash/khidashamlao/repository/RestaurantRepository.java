package org.shakilsmash.khidashamlao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.shakilsmash.khidashamlao.model.Restaurant;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

}