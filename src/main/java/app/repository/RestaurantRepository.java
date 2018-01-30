package app.repository;

import org.springframework.data.repository.CrudRepository;

import app.model.Restaurant;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {

}