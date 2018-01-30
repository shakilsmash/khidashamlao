package app.repository;

import org.springframework.data.repository.CrudRepository;

import app.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}