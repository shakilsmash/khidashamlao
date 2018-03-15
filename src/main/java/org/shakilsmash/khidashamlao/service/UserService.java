package org.shakilsmash.khidashamlao.service;

import org.shakilsmash.khidashamlao.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by shakilsmash on 2/22/2018.
 */
public interface UserService {

    User save(User user);

    User retrieve(long id);

    Page<User> retrieveAll(Pageable pageable);

    void updatePassword(long id, String password);

    void delete(long id);

    void deletePermanently(long id);

}
