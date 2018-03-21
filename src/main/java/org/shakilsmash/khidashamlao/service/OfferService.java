package org.shakilsmash.khidashamlao.service;

import org.shakilsmash.khidashamlao.domain.Offer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OfferService {

    /**
     * Saves a offer.
     *
     * @param offer is the id of the object that is to be saved
     * @return null
     */
    Offer save(Offer offer);

    /**
     * @param id is the id of the object that is to be returned
     * @return the offer object
     */
    Offer retrieve(long id);

    /**
     * @return all the offer objects available on the database
     */
    Page<Offer> retrieveAll(Pageable pageable);

    /**
     * Updates the offer status and deletion time but doesn't delete the entity from the database.
     * @return null
     */
    void delete(long id);

    /**
     * Deletes the offer entity from the database.
     * @return null
     */
    void deletePermanently(long id);

}
