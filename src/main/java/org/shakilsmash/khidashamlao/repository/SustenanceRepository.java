package org.shakilsmash.khidashamlao.repository;

import org.shakilsmash.khidashamlao.model.Sustenance;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface SustenanceRepository extends JpaRepository<Sustenance, Long> {


}