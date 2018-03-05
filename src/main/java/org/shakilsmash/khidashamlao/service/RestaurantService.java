package org.shakilsmash.khidashamlao.service;

import org.shakilsmash.khidashamlao.model.Restaurant;
import org.shakilsmash.khidashamlao.model.Status;
import org.shakilsmash.khidashamlao.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;
    private Restaurant restaurant;

    public void createRestaurant(String name, String description, double vat, String email, String mobile, String street, String city, String state, String zipCode, Timestamp openingTime, Timestamp closingTime, Restaurant.Cuisine cuisineSpecialty, Restaurant.Environment environmentType, boolean advancedBooking, boolean delivery) {
        this.restaurant = new Restaurant(name, description, vat, email, mobile, street, city, state, zipCode, openingTime, closingTime, cuisineSpecialty, environmentType, advancedBooking, delivery);
        restaurantRepository.save(restaurant);
    }

    public Restaurant retrieveRestaurant(long id) {
        return restaurantRepository.findOne(id);
    }

    public Iterable<Restaurant> retrieveAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public void updateRestaurant(long id, String name, String description, double vat, String email, String mobile, String street, String city, String state, String zipCode, Timestamp openingTime, Timestamp closingTime, Restaurant.Cuisine cuisineSpecialty, Restaurant.Environment environmentType, boolean advancedBooking, boolean delivery) {
        this.restaurant = retrieveRestaurant(id);
        this.restaurant.setName(name);
        this.restaurant.setDescription(description);
        this.restaurant.setVat(vat);
        this.restaurant.setEmail(email);
        this.restaurant.setMobile(mobile);
        this.restaurant.setStreet(street);
        this.restaurant.setCity(city);
        this.restaurant.setState(state);
        this.restaurant.setZipCode(zipCode);
        this.restaurant.setOpeningTime(openingTime);
        this.restaurant.setClosingTime(closingTime);
        this.restaurant.setCuisineSpecialty(cuisineSpecialty);
        this.restaurant.setEnvironmentType(environmentType);
        this.restaurant.setAdvancedBooking(advancedBooking);
        this.restaurant.setDelivery(delivery);
        updateModificationDate();
        save();
    }

    public void changeRestaurantStatus(long id, Status status) {
        this.restaurant = retrieveRestaurant(id);
        this.restaurant.setStatus(status);
        updateModificationDate();
        save();
    }

    public void deleteRestaurant(long id) {
        this.restaurant = retrieveRestaurant(id);
        this.restaurant.setDeletedAt(new Timestamp(new Date().getTime()));
        this.restaurant.setStatus(Status.DELETED);
        save();
    }

    private void updateModificationDate() {
        this.restaurant.setLastModifiedAt(new Timestamp(new Date().getTime()));
        save();
    }

    private void save() {
        restaurantRepository.save(this.restaurant);
    }
}
