package org.shakilsmash.khidashamlao.repository;

import org.shakilsmash.khidashamlao.domain.Cuisine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by shakilsmash on 3/21/2018.
 */
@Repository
public interface CuisineRepository extends JpaRepository<Cuisine, Long> {
}
