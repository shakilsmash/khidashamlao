package org.shakilsmash.khidashamlao.service;

import org.shakilsmash.khidashamlao.model.Status;
import org.shakilsmash.khidashamlao.model.User;
import org.shakilsmash.khidashamlao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Saves a user.
     *
     * @param user is the id of the object that is to be saved
     * @return null
     */
    public User save(User user) {
        return userRepository.save(user);
    }

    /**
     * @param id is the id of the object that is to be returned
     * @return the user object
     */
    public User retrieve(long id) {
        return userRepository.findOne(id);
    }

    /**
     * @return all the user objects available on the database
     */
    public Page<User> retrieveAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public void updatePassword(long id, String password) {
        userRepository.updatePassword(id, password);
    }

    /**
     * Updates the user status and deletion time but doesn't delete the entity from the database.
     * @return null
     */
    public void delete(long id) {
        User user = userRepository.findOne(id);
        user.setStatus(Status.DELETED);
        user.setDeletedAt(new Timestamp(new Date().getTime()));
        userRepository.save(user);
    }

    /**
     * Deletes the user entity from the database.
     * @return null
     */
    public void deletePermanently(long id) {
        userRepository.delete(id);
    }
}
