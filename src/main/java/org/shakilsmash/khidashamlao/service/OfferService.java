package org.shakilsmash.khidashamlao.service;

import org.shakilsmash.khidashamlao.model.Offer;
import org.shakilsmash.khidashamlao.model.Status;
import org.shakilsmash.khidashamlao.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class OfferService {

    @Autowired
    private OfferRepository offerRepository;
    private Offer offer;

    public void createOffer(String name, String description, double discountPercentage, Timestamp startDate, Timestamp endDate, long foodID, long restaurantID) {
        this.offer = new Offer(name, description, discountPercentage, startDate, endDate, foodID, restaurantID);
        save();
    }

    public Offer retrieveOffer(long id) {
        return offerRepository.findOne(id);
    }

    public Iterable<Offer> retrieveAllOffers() {
        return offerRepository.findAll();
    }

    public void updateOffer(long id, String name, String description, double discountPercentage, Timestamp startDate, Timestamp endDate, long foodID) {
        this.offer = retrieveOffer(id);
        this.offer.setName(name);
        this.offer.setDescription(description);
        this.offer.setDiscountPercentage(discountPercentage);
        this.offer.setStartDate(startDate);
        this.offer.setEndDate(endDate);
        this.offer.setFoodID(foodID);
        updateModificationDate();
        save();
    }

    public void changeStatus(long id, Status status) {
        this.offer = retrieveOffer(id);
        this.offer.setStatus(status);
        updateModificationDate();
        save();
    }

    public void deleteOffer(long id) {
        this.offer = retrieveOffer(id);
        this.offer.setDeletedAt(new Timestamp(new Date().getTime()));
        this.offer.setStatus(Status.DELETED);
        save();
    }

    private void updateModificationDate() {
        this.offer.setLastModifiedAt(new Timestamp(new Date().getTime()));
        save();

    }

    private void save() {
        offerRepository.save(this.offer);
    }
}
