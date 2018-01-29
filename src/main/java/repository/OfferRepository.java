package repository;

import org.springframework.data.repository.CrudRepository;

import model.Offer;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends CrudRepository<Offer, Long> {

}