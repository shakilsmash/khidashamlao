package org.shakilsmash.khidashamlao.repository;

import org.shakilsmash.khidashamlao.model.Sustenance;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface SustenanceRepository extends CrudRepository<Sustenance, Long> {


}