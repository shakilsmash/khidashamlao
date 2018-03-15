package org.shakilsmash.khidashamlao.repository;

import org.shakilsmash.khidashamlao.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {

}