package org.shakilsmash.khidashamlao.controller;

import org.shakilsmash.khidashamlao.model.Offer;
import org.shakilsmash.khidashamlao.model.Status;
import org.shakilsmash.khidashamlao.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;

@Controller
@RequestMapping(value = "offer")
public class OfferController {

    private OfferService offerService;

    @Autowired
    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @RequestMapping(value = "createOffer")
    @ResponseBody
    public String createUser(@RequestParam String name,
                             @RequestParam String description,
                             @RequestParam double discountPercentage,
                             @RequestParam Timestamp startDate,
                             @RequestParam Timestamp endDate,
                             @RequestParam long foodID,
                             @RequestParam long restaurantID) {
        offerService.createOffer(name, description, discountPercentage, startDate, endDate, foodID, restaurantID);
        return "Offer created.";
    }

    @RequestMapping(value = "retrieveOffer")
    @ResponseBody
    public Offer retrieveOffer(@RequestParam long id) {
        return offerService.retrieveOffer(id);
    }

    @RequestMapping(value = "retrieveAllOffers")
    @ResponseBody
    public Iterable<Offer> retrieveAllOffers() {
        return offerService.retrieveAllOffers();
    }

    @RequestMapping(value = "updateOffer")
    @ResponseBody
    public String updateOffer(@RequestParam long id,
                             @RequestParam String name,
                             @RequestParam String description,
                             @RequestParam double discountPercentage,
                             @RequestParam Timestamp startDate,
                             @RequestParam Timestamp endDate,
                             @RequestParam long foodID) {
        offerService.updateOffer(id, name, description, discountPercentage, startDate, endDate, foodID);
        return "Offer updated.";
    }

    @RequestMapping(value = "changeOfferStatus")
    @ResponseBody
    public String changeOfferStatus(@RequestParam long id,
                                    @RequestParam Status status) {
        offerService.changeStatus(id, status);
        return "Status changed of the offer";
    }

    @RequestMapping(value = "deleteStatus")
    @ResponseBody
    public String deleteOffer(@RequestParam long id) {
        offerService.deleteOffer(id);
        return "Offer deleted";
    }
}
