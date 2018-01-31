package app.controller;

import app.model.Food;
import app.model.Status;
import app.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "food")
public class FoodController {

    private FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @RequestMapping(value = "createFood")
    @ResponseBody
    public String createFood(@RequestParam String name,
                             @RequestParam String description,
                             @RequestParam long restaurantID,
                             @RequestParam Food.FoodType type,
                             @RequestParam double unitPrice) {
        foodService.createFood(name, description, restaurantID, type, unitPrice);
        return "Food Created";
    }

    @RequestMapping(value = "retrieveFood")
    @ResponseBody
    public Food retrieveFood(@RequestParam long id) {
        return foodService.retrieveFood(id);
    }

    @RequestMapping(value = "retrieveAllFood")
    @ResponseBody
    public Iterable<Food> retrieveAllFood() {
        return foodService.retrieveAllFood();
    }

    @RequestMapping(value = "updateFood")
    @ResponseBody
    public String createFood(@RequestParam long id,
                             @RequestParam String name,
                             @RequestParam String description,
                             @RequestParam Food.FoodType type,
                             @RequestParam double unitPrice) {
        foodService.updateFood(id, name, description, type, unitPrice);
        return "Food updated";
    }

    @RequestMapping(value = "changeFoodStatus")
    @ResponseBody
    public String retrieveFood(@RequestParam long id,
                               @RequestParam Status status) {
        foodService.changeFoodStatus(id, status);
        return "Changed status";
    }

    @RequestMapping(value = "deleteFood")
    @ResponseBody
    public String deleteFood(@RequestParam long id) {
        foodService.deleteFood(id);
        return "Food Deleted";
    }
}
