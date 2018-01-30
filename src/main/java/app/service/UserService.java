package app.service;

import app.model.Status;
import app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.repository.UserRepository;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void createUser(String firstName, String lastName, User.Sex sex, Date dateOfBirth, String username, String password, String email, String mobile, String street, String city, String state, String zipCode, User.Role role) {
        User n = new User(firstName, lastName, sex, dateOfBirth, username, password, email, mobile, street, city, state, zipCode, role);
        userRepository.save(n);
    }

    public User retrieveUser(long id) {
        return userRepository.findOne(id);
    }

    public Iterable<User> retrieveAllUsers() {
        return userRepository.findAll();
    }

    public void updateUser(long id, String firstName, String lastName, Date dateOfBirth, String email, String mobile, String street, String city, String state, String zipCode) {
        userRepository.findOne(id).setFirstName(firstName);
        userRepository.findOne(id).setLastName(lastName);
        userRepository.findOne(id).setDateOfBirth(dateOfBirth);
        userRepository.findOne(id).setEmail(email);
        userRepository.findOne(id).setMobile(mobile);
        userRepository.findOne(id).setStreet(street);
        userRepository.findOne(id).setCity(city);
        userRepository.findOne(id).setState(state);
        userRepository.findOne(id).setZipCode(zipCode);
        updateModificationDate(id);
    }

    public void changeUserPassword(long id, String password) {
        userRepository.findOne(id).setPassword(password);
        updateModificationDate(id);
    }

    public void changeUserRole(long id, User.Role role) {
        userRepository.findOne(id).setRole(role);
        updateModificationDate(id);
    }

    public void changeUserStatus(long id, Status status) {
        userRepository.findOne(id).setStatus(status);
        updateModificationDate(id);
    }

    public void deleteUser(long id) {
        userRepository.delete(id);
        userRepository.findOne(id).setDeletedAt(new Timestamp(new Date().getTime()));
    }

    private void updateModificationDate(long id) {
        userRepository.findOne(id).setLastModifiedAt(new Timestamp(new Date().getTime()));
    }
}
