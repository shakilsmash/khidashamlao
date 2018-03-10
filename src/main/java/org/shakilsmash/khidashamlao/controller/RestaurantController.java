package org.shakilsmash.khidashamlao.controller;

import org.shakilsmash.khidashamlao.model.Restaurant;
import org.shakilsmash.khidashamlao.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "restaurant")
public class RestaurantController {

    private RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    /**
     * POST /restaurant : Create a new restaurant to be inserted into the database
     *
     * @param restaurant is the object that is initiated with the information from the input JSON
     * @return the ResponseEntity with status 200 (OK) and with restaurant in the body, or with status 404 (Not Found)
     */
    @PostMapping(value = "")
    public ResponseEntity<Restaurant> createRestaurant(@Valid @RequestBody Restaurant restaurant) {
        Restaurant result = restaurantService.save(restaurant);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * GET /restaurant/:id : Get a restaurant from the database with the given id
     *
     * @param id specifies the id of the object of the restaurant that is to be shown from the database
     * @return Returns and displays all the information of the fetched restaurant in JSON format.
     */
    @GetMapping(value = "{id}")
    public Restaurant retrieveRestaurant(@RequestParam long id) {
        return restaurantService.retrieve(id);
    }

    /**
     * GET /restaurant/ : Get all the restaurants from the database
     *
     * @return Returns and displays all the information of the fetched restaurants in JSON format.
     */
    @GetMapping(value = "")
    public ResponseEntity<Iterable<Restaurant>> retrieveRestaurant() {
        return new ResponseEntity<>(restaurantService.retrieveAll(), HttpStatus.OK);
    }

    /**
     * PUT /restaurant/:id : Updates restaurant's basic info.
     *
     * @param restaurant is the object that is initiated with the information from the input JSON
     * @return the ResponseEntity with status 200 (OK) and with restaurant in the body, or with status 404 (Not Found)
     */
    @PutMapping(value = "{id}")
    public ResponseEntity<Restaurant> updateRestaurant(@Valid @RequestBody Restaurant restaurant) {
        Restaurant result = restaurantService.save(restaurant);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * PUT /restaurant/delete:id : Soft deletes a restaurant.
     *
     * @param id is the id of the object that is to be deleted
     * @return A success message
     */
    @PutMapping(value = "delete/{id}")
    public String deleteRestaurant(@PathVariable long id) {
        restaurantService.delete(id);
        return "Restaurant deleted.";
    }

    /**
     * DELETE /restaurant/:id : Hard deletes a restaurant.
     *
     * @param id is the id of the object that is to be deleted
     * @return A success message
     */
    @DeleteMapping(value = "{id}")
    public String deleteRestaurantPermanently(@RequestParam long id) {
        restaurantService.deletePermanently(id);
        return "Restaurant deleted.";
    }
}
