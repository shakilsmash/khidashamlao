package app.mapper;

import app.model.User;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by shakilsmash on 2/23/2018.
 */
public class UserMapper {
    private User user;
    private User auxilaryUser;

    public UserMapper(User user, User auxilaryUser) {
        this.user = user;
        this.auxilaryUser = auxilaryUser;
    }

       public User updatePassword() {
        user.setPassword(auxilaryUser.getPassword());
        updateModificationDate();
        return this.user;
    }

    public User updateInfo() {
        user.setFirstName(auxilaryUser.getFirstName());
        user.setLastName(auxilaryUser.getLastName());
        user.setEmail(auxilaryUser.getEmail());
        user.setMobile(auxilaryUser.getMobile());
        user.setStreet(auxilaryUser.getStreet());
        user.setCity(auxilaryUser.getCity());
        user.setState(auxilaryUser.getState());
        user.setZipCode(auxilaryUser.getZipCode());
        updateModificationDate();
        return this.user;
    }

    public User updateInfoAdmin() {
        user.setStatus(auxilaryUser.getStatus());
        user.setRole(auxilaryUser.getRole());
        updateModificationDate();
        return this.user;
    }

    private void updateModificationDate() {
        user.setModifiedAt(new Timestamp(new Date().getTime()));
    }
}
