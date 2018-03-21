package org.shakilsmash.khidashamlao.repository;

import org.shakilsmash.khidashamlao.domain.SustenanceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SustenanceTypeRepository extends JpaRepository<SustenanceType, Long> {
}
