package org.shakilsmash.khidashamlao.service;

import org.shakilsmash.khidashamlao.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by shakilsmash on 2/22/2018.
 */
public interface UserService {

    /**
     * Saves a user.
     *
     * @param user is the id of the object that is to be saved
     * @return null
     */
    User save(User user);

    /**
     * @param id is the id of the object that is to be returned
     * @return the user object
     */
    User retrieve(long id);

    /**
     * @return all the user objects available on the database
     */
    Page<User> retrieveAll(Pageable pageable);

    /**
     * Updates the user password
     * @return null
     */
    void updatePassword(long id, String password);

    /**
     * Updates the user status and deletion time but doesn't delete the entity from the database.
     * @return null
     */
    void delete(long id);

    /**
     * Deletes the user entity from the database.
     * @return null
     */
    void deletePermanently(long id);

}
