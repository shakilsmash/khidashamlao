package org.shakilsmash.khidashamlao.repository;

import org.shakilsmash.khidashamlao.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE User u set u.password = ?2 WHERE u.id = ?1", nativeQuery = true)
    void updatePassword(long id, String password);
}