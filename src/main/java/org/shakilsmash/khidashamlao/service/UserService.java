package org.shakilsmash.khidashamlao.service;

import org.shakilsmash.khidashamlao.model.User;

/**
 * Created by shakilsmash on 2/22/2018.
 */
public interface UserService {

    User save(User user);

    User retrieveUser(long id);

    Iterable<User> retrieveAllUsers();

    void deleteUser(long id);

    void deleteUserPermanently(long id);

}
