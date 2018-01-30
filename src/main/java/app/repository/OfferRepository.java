package app.repository;

import org.springframework.data.repository.CrudRepository;

import app.model.Offer;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends CrudRepository<Offer, Long> {

}