package org.shakilsmash.khidashamlao.service;

import org.shakilsmash.khidashamlao.domain.Offer;
import org.shakilsmash.khidashamlao.domain.Status;
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
     * @inheritDoc
     */
    public Offer save(Offer offer) {
        return offerRepository.save(offer);
    }

    /**
     * @inheritDoc
     */
    public Offer retrieve(long id) {
        return offerRepository.findOne(id);
    }

    /**
     * @inheritDoc
     */
    public Page<Offer> retrieveAll(Pageable pageable) {
        return offerRepository.findAll(pageable);
    }

    /**
     * @inheritDoc
     */
    public void delete(long id) {
        Offer offer = offerRepository.findOne(id);
        offer.setStatus(Status.DELETED);
        offer.setDeletedAt(new Timestamp(new Date().getTime()));
        offerRepository.save(offer);
    }

    /**
     * @inheritDoc
     */
    public void deletePermanently(long id) {
        offerRepository.delete(id);
    }
}
