package repository;

import org.springframework.data.repository.CrudRepository;

import model.Food;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends CrudRepository<Food, Long> {

}