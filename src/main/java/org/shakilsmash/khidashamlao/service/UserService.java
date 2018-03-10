package org.shakilsmash.khidashamlao.service;

import org.shakilsmash.khidashamlao.model.User;

/**
 * Created by shakilsmash on 2/22/2018.
 */
public interface UserService {

    User save(User user);

    User retrieve(long id);

    Iterable<User> retrieveAll();

    void updatePassword(long id, String password);

    void delete(long id);

    void deletePermanently(long id);

}
