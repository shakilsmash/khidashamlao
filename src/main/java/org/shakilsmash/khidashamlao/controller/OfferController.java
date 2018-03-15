package org.shakilsmash.khidashamlao.controller;

import org.shakilsmash.khidashamlao.model.Offer;
import org.shakilsmash.khidashamlao.service.OfferService;
import org.shakilsmash.khidashamlao.util.PaginationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
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
import java.util.List;

@RestController
@RequestMapping(value = "offer")
public class OfferController {

    private OfferService offerService;

    @Autowired
    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    /**
     * POST /offer : Create a new offer to be inserted into the database
     *
     * @param offer is the object that is initiated with the information from the input JSON
     * @return the ResponseEntity with status 200 (OK) and with offer in the body, or with status 404 (Not Found)
     */
    @PostMapping(value = "")
    public ResponseEntity<Offer> createOffer(@Valid @RequestBody Offer offer) {
        Offer result = offerService.save(offer);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * GET /offer/:id : Get a offer from the database with the given id
     *
     * @param id specifies the id of the object of the offer that is to be shown from the database
     * @return Returns and displays all the information of the fetched offer in JSON format.
     */
    @GetMapping(value = "{id}")
    public Offer retrieveOffer(@RequestParam long id) {
        return offerService.retrieve(id);
    }

    /**
     * GET /offer/ : Get all the offers from the database
     *
     * @return Returns and displays all the information of the fetched offers in JSON format.
     */
    @GetMapping(value = "")
    public ResponseEntity<List<Offer>> retrieveAllOffers(Pageable pageable) {
        Page<Offer> page = offerService.retrieveAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "localhost:8080/offer");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * PUT /offer/:id : Updates offer's basic info.
     *
     * @param offer is the object that is initiated with the information from the input JSON
     * @return the ResponseEntity with status 200 (OK) and with offer in the body, or with status 404 (Not Found)
     */
    @PutMapping(value = "{id}")
    public ResponseEntity<Offer> updateOffer(@Valid @RequestBody Offer offer) {
        Offer result = offerService.save(offer);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * PUT /offer/delete:id : Soft deletes a offer.
     *
     * @param id is the id of the object that is to be deleted
     * @return A success message
     */
    @PutMapping(value = "delete/{id}")
    public String deleteOffer(@PathVariable long id) {
        offerService.delete(id);
        return "Offer deleted.";
    }

    /**
     * DELETE /offer/:id : Hard deletes a offer.
     *
     * @param id is the id of the object that is to be deleted
     * @return A success message
     */
    @DeleteMapping(value = "{id}")
    public String deleteOfferPermanently(@RequestParam long id) {
        offerService.deletePermanently(id);
        return "Offer deleted.";
    }
}
