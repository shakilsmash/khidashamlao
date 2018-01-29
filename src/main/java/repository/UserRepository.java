package repository;

import org.springframework.data.repository.CrudRepository;

import model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}