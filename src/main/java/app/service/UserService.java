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

    /**
     * @param user is the id of the object that is to be saved
     * @return null
     */
    public void saveUser(User user) {
        userRepository.save(user);
    }

    /**
     * @param id is the id of the object that is to be returned
     * @return the user object
     */
    public User retrieveUser(long id) {
        return userRepository.findOne(id);
    }

    /**
     * @return all the user objects available on the database
     */
    public Iterable<User> retrieveAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Updates the user status and deletion time but doesn't delete the entity from the database.
     * @return null
     */
    public void deleteUser(long id) {
        this.user = retrieveUser(id);
        user.setStatus(Status.DELETED);
        user.setDeletedAt(new Timestamp(new Date().getTime()));
    }

    /**
     * Deletes the user entity from the database.
     * @return null
     */
    public void deleteUserPermanently(long id) {
        userRepository.delete(id);
    }
}
