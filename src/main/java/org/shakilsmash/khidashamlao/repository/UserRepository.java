package org.shakilsmash.khidashamlao.repository;

import org.shakilsmash.khidashamlao.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
}