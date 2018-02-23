package app.mapper;

import app.model.User;

/**
 * Created by shakilsmash on 2/23/2018.
 */
public class UserMapper {
    private User user;

    public UserMapper(User user) {
        this.user = user;
    }

    public User updatePassword(String password) {
        user.setPassword(password);
        return this.user;
    }
}
