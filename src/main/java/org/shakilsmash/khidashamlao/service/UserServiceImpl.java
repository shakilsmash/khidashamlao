package org.shakilsmash.khidashamlao.service;

import org.shakilsmash.khidashamlao.domain.Status;
import org.shakilsmash.khidashamlao.domain.User;
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
     * @inheritDoc
     */
    public User save(User user) {
        return userRepository.save(user);
    }

    /**
     * @inheritDoc
     */
    public User retrieve(long id) {
        return userRepository.findById(id).get();
    }

    /**
     * @inheritDoc
     */
    public Page<User> retrieveAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    /**
     * @inheritDoc
     */
    public void updatePassword(long id, String password) {
        userRepository.updatePassword(id, password);
    }

    /**
     * @inheritDoc
     */
    public void delete(long id) {
        User user = userRepository.findById(id).get();
        user.setStatus(Status.DELETED);
        user.setDeletedAt(new Timestamp(new Date().getTime()));
        userRepository.save(user);
    }

    /**
     * @inheritDoc
     */
    public void deletePermanently(long id) {
        userRepository.deleteById(id);
    }
}
