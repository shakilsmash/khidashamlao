package app.service;

import app.model.Status;
import app.model.User;
import app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    private User user;

    public void createUser(String firstName, String lastName, User.Sex sex, Date dateOfBirth, String username, String password, String email, String mobile, String street, String city, String state, String zipCode, User.Role role) {
        this.user = new User(firstName, lastName, sex, dateOfBirth, username, password, email, mobile, street, city, state, zipCode, role);
        save();
    }

    public User retrieveUser(long id) {
        return userRepository.findOne(id);
    }

    public Iterable<User> retrieveAllUsers() {
        return userRepository.findAll();
    }

    public void updateUser(long id, String firstName, String lastName, Date dateOfBirth, String email, String mobile, String street, String city, String state, String zipCode) {
        this.user = retrieveUser(id);
        this.user.setFirstName(firstName);
        this.user.setLastName(lastName);
        this.user.setDateOfBirth(dateOfBirth);
        this.user.setEmail(email);
        this.user.setMobile(mobile);
        this.user.setStreet(street);
        this.user.setCity(city);
        this.user.setState(state);
        this.user.setZipCode(zipCode);
        updateModificationDate();
        save();
    }

    public void changeUserPassword(long id, String password) {
        this.user = retrieveUser(id);
        this.user.setPassword(password);
        updateModificationDate();
        save();
    }

    public void changeUserRole(long id, User.Role role) {
        this.user = retrieveUser(id);
        this.user.setRole(role);
        updateModificationDate();
        save();
    }

    public void changeUserStatus(long id, Status status) {
        this.user = retrieveUser(id);
        this.user.setStatus(status);
        updateModificationDate();
        save();
    }

    public void deleteUser(long id) {
        this.user = retrieveUser(id);
        this.user.setDeletedAt(new Timestamp(new Date().getTime()));
        this.user.setStatus(Status.DELETED);
        save();
    }

    private void updateModificationDate() {
        this.user.setLastModifiedAt(new Timestamp(new Date().getTime()));
        save();

    }

    private void save() {
        userRepository.save(this.user);
    }
}
