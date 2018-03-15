package org.shakilsmash.khidashamlao.service;

import org.shakilsmash.khidashamlao.model.Offer;
import org.shakilsmash.khidashamlao.model.Status;
import org.shakilsmash.khidashamlao.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class OfferServiceImpl implements OfferService{

    private final OfferRepository offerRepository;

    @Autowired
    public OfferServiceImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    /**
     * Saves a offer.
     *
     * @param offer is the id of the object that is to be saved
     * @return null
     */
    public Offer save(Offer offer) {
        return offerRepository.save(offer);
    }

    /**
     * @param id is the id of the object that is to be returned
     * @return the offer object
     */
    public Offer retrieve(long id) {
        return offerRepository.findOne(id);
    }

    /**
     * @return all the offer objects available on the database
     */
    public Page<Offer> retrieveAll(Pageable pageable) {
        return offerRepository.findAll(pageable);
    }

    /**
     * Updates the offer status and deletion time but doesn't delete the entity from the database.
     * @return null
     */
    public void delete(long id) {
        Offer offer = offerRepository.findOne(id);
        offer.setStatus(Status.DELETED);
        offer.setDeletedAt(new Timestamp(new Date().getTime()));
        offerRepository.save(offer);
    }

    /**
     * Deletes the offer entity from the database.
     * @return null
     */
    public void deletePermanently(long id) {
        offerRepository.delete(id);
    }
}
