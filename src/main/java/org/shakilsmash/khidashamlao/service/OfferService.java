package org.shakilsmash.khidashamlao.service;

import org.shakilsmash.khidashamlao.model.Offer;

/**
 * Created by shakilsmash on 3/10/2018.
 */
public interface OfferService {

    Offer save(Offer offer);

    Offer retrieve(long id);

    Iterable<Offer> retrieveAll();

    void delete(long id);

    void deletePermanently(long id);

}
