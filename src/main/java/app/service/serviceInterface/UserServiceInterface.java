package app.service.serviceInterface;

import app.model.User;
import app.repository.UserRepository;

/**
 * Created by shakilsmash on 2/22/2018.
 */
public interface UserServiceInterface {

    void saveUser(User user);

    User retrieveUser(long id);

    Iterable<User> retrieveAllUsers();

    void deleteUser(long id);

}
