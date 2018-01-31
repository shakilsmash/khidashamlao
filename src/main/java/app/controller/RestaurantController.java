package app.controller;

import app.model.Restaurant;
import app.model.Status;
import app.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;

@Controller
@RequestMapping(value = "restaurant")
public class RestaurantController {

    private RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @RequestMapping(value = "createRestaurant")
    @ResponseBody
    public String createRestaurant(@RequestParam String name,
                                   @RequestParam String description,
                                   @RequestParam double vat,
                                   @RequestParam String email,
                                   @RequestParam String mobile,
                                   @RequestParam String street,
                                   @RequestParam String city,
                                   @RequestParam String state,
                                   @RequestParam String zipCode,
                                   @RequestParam Timestamp openingTime,
                                   @RequestParam Timestamp closingTime,
                                   @RequestParam Restaurant.Cuisine cuisineSpecialty,
                                   @RequestParam Restaurant.Environment environmentType,
                                   @RequestParam boolean advancedBooking,
                                   @RequestParam boolean delivery) {
        restaurantService.createRestaurant(name, description, vat, email, mobile, street, city, state, zipCode, openingTime, closingTime, cuisineSpecialty, environmentType, advancedBooking, delivery);
        return "Restauranta added!";
    }

    @RequestMapping(value = "retrieveRestaurant")
    @ResponseBody
    public Restaurant retrieveRestaurant(@RequestParam long id) {
        return restaurantService.retrieveRestaurant(id);
    }

    @RequestMapping(value = "retrieveAllRestaurants")
    @ResponseBody
    public Iterable<Restaurant> retrieveRestaurant() {
        return restaurantService.retrieveAllRestaurants();
    }

    @RequestMapping(value = "updateRestaurant")
    @ResponseBody
    public String updateRestaurant(@RequestParam long id,
                                   @RequestParam String name,
                                   @RequestParam String description,
                                   @RequestParam double vat,
                                   @RequestParam String email,
                                   @RequestParam String mobile,
                                   @RequestParam String street,
                                   @RequestParam String city,
                                   @RequestParam String state,
                                   @RequestParam String zipCode,
                                   @RequestParam Timestamp openingTime,
                                   @RequestParam Timestamp closingTime,
                                   @RequestParam Restaurant.Cuisine cuisineSpecialty,
                                   @RequestParam Restaurant.Environment environmentType,
                                   @RequestParam boolean advancedBooking,
                                   @RequestParam boolean delivery) {
        restaurantService.updateRestaurant(id, name, description, vat, email, mobile, street, city, state, zipCode, openingTime, closingTime, cuisineSpecialty, environmentType, advancedBooking, delivery);
        return "Restaurant updated!";
    }

    @RequestMapping(value = "changeRestaurantStatus")
    @ResponseBody
    public String changeRestaurantStatus(@RequestParam long id,
                                         @RequestParam Status status) {
        restaurantService.changeRestaurantStatus(id, status);
        return "Status of the restaurant changed.";
    }

    @RequestMapping(value = "deleteRestaurant")
    @ResponseBody
    public String deleteRestaurant(@RequestParam long id) {
        restaurantService.deleteRestaurant(id);
        return "Restaurant deleted.";
    }
}
