package org.shakilsmash.khidashamlao.repository;

import org.shakilsmash.khidashamlao.domain.Environment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnvironmentRepository extends JpaRepository<Environment, Long> {
}
