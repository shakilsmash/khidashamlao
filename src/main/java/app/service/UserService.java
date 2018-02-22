package app.service;

import app.model.Status;
import app.model.User;
import app.repository.UserRepository;
import app.service.serviceInterface.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class UserService implements UserServiceInterface {

    private final UserRepository userRepository;
    private User user;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public User retrieveUser(long id) {
        return userRepository.findOne(id);
    }

    public Iterable<User> retrieveAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(long id) {
        userRepository.delete(id);
    }

}
