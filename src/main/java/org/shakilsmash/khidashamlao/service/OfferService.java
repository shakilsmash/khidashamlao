package org.shakilsmash.khidashamlao.service;

import org.shakilsmash.khidashamlao.model.Offer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by shakilsmash on 3/10/2018.
 */
public interface OfferService {

    Offer save(Offer offer);

    Offer retrieve(long id);

    Page<Offer> retrieveAll(Pageable pageable);

    void delete(long id);

    void deletePermanently(long id);

}
