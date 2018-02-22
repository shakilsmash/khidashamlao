package app.controller;

import app.model.Food;
import app.model.Status;
import app.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "food")
public class FoodController {

    private final FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping(value = "createFood")
    public String createFood(@RequestParam String name,
                             @RequestParam String description,
                             @RequestParam long restaurantID,
                             @RequestParam Food.FoodType type,
                             @RequestParam double unitPrice) {
        foodService.createFood(name, description, restaurantID, type, unitPrice);
        return "Food Created";
    }
    //localhost/users/10
    @RequestMapping(value = "retrieveFood")
    public Food retrieveFood(@RequestParam long id) {
        return foodService.retrieveFood(id);
    }

    @RequestMapping(value = "retrieveAllFood")
    public Iterable<Food> retrieveAllFood() {
        return foodService.retrieveAllFood();
    }

    @RequestMapping(value = "updateFood")
    public String createFood(@RequestParam long id,
                             @RequestParam String name,
                             @RequestParam String description,
                             @RequestParam Food.FoodType type,
                             @RequestParam double unitPrice) {
        foodService.updateFood(id, name, description, type, unitPrice);
        return "Food updated";
    }

    @RequestMapping(value = "changeFoodStatus")
    public String retrieveFood(@RequestParam long id,
                               @RequestParam Status status) {
        foodService.changeFoodStatus(id, status);
        return "Changed status";
    }

    @RequestMapping(value = "deleteFood")
    public String deleteFood(@RequestParam long id) {
        foodService.deleteFood(id);
        return "Food Deleted";
    }
}
