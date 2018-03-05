package org.shakilsmash.khidashamlao.repository;

import org.shakilsmash.khidashamlao.model.Offer;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends CrudRepository<Offer, Long> {

}