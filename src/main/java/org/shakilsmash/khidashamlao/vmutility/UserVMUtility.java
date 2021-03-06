package org.shakilsmash.khidashamlao.vmutility;

import org.shakilsmash.khidashamlao.domain.User;
import org.shakilsmash.khidashamlao.vm.UserVM;

/**
 * Created by shakilsmash on 3/5/2018.
 */
public class UserVMUtility {

    public static User mapToUser(UserVM userVM) {
        User user = new User();
        user.setFirstName(userVM.getFirstName());
        user.setLastName(userVM.getLastName());
        user.setGender(userVM.getGender());
        user.setDateOfBirth(userVM.getDateOfBirth());
        user.setUsername(userVM.getUsername());
        user.setPassword(userVM.getPassword());
        user.setEmail(userVM.getEmail());
        user.setMobile(userVM.getMobile());
        user.setStreet(userVM.getStreet());
        user.setCity(userVM.getCity());
        user.setState(userVM.getState());
        user.setZipCode(userVM.getZipCode());
        return user;
    }
}
