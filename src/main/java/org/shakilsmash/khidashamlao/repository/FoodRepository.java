package org.shakilsmash.khidashamlao.repository;

import org.shakilsmash.khidashamlao.model.Food;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends CrudRepository<Food, Long> {


}