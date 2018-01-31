package app.service;

import app.model.Food;
import app.model.Status;
import app.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;
    private Food food;

    public void createFood(String name, String description, long restaurantID, Food.FoodType type, double unitPrice) {
        this.food = new Food(name, description, restaurantID, type, unitPrice);
        save();
    }

    public Food retrieveFood(long id) {
        return foodRepository.findOne(id);
    }

    public Iterable<Food> retrieveAllFood() {
        return foodRepository.findAll();
    }

    public void updateFood(long id, String name, String description, Food.FoodType type, double unitPrice) {
        this.food = retrieveFood(id);
        this.food.setName(name);
        this.food.setDescription(description);
        this.food.setType(type);
        this.food.setUnitPrice(unitPrice);
        updateModificationDate();
        save();
    }

    public void changeFoodStatus(long id, Status status) {
        this.food = retrieveFood(id);
        this.food.setStatus(status);
        updateModificationDate();
        save();
    }

    public void deleteFood(long id) {
        this.food = retrieveFood(id);
        this.food.setDeletedAt(new Timestamp(new Date().getTime()));
        this.food.setStatus(Status.DELETED);
        save();
    }

    private void updateModificationDate() {
        this.food.setLastModifiedAt(new Timestamp(new Date().getTime()));
        save();
    }

    private void save() {
        foodRepository.save(this.food);
    }

}
