package org.shakilsmash.khidashamlao.repository;

import org.shakilsmash.khidashamlao.domain.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {

}