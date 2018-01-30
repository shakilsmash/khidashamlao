package app.controller;

import app.model.Status;
import app.model.User;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping(value = "user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "createUser")
    @ResponseBody
    public String createUser(@RequestParam String firstName,
                             @RequestParam String lastName,
                             @RequestParam User.Sex sex,
                             @RequestParam Date dateOfBirth,
                             @RequestParam String username,
                             @RequestParam String password,
                             @RequestParam String email,
                             @RequestParam String mobile,
                             @RequestParam String street,
                             @RequestParam String city,
                             @RequestParam String state,
                             @RequestParam String zipCode,
                             @RequestParam User.Role role) {
        userService.createUser(firstName, lastName, sex, dateOfBirth, username, password, email, mobile, street, city, state, zipCode, role);
        return "Added to the database!";
    }

    @RequestMapping(value = "retrieveUser")
    @ResponseBody
    public User retrieveUser(@RequestParam long id) {
        return userService.retrieveUser(id);
    }

    @RequestMapping(value = "retrieveAllUsers")
    @ResponseBody
    public Iterable<User> retrieveAllUsers() {
        return userService.retrieveAllUsers();
    }

    @RequestMapping(value = "updateUser")
    @ResponseBody
    public String updateUser(@RequestParam long id,
                             @RequestParam String firstName,
                             @RequestParam String lastName,
                             @RequestParam Date dateOfBirth,
                             @RequestParam String email,
                             @RequestParam String mobile,
                             @RequestParam String street,
                             @RequestParam String city,
                             @RequestParam String state,
                             @RequestParam String zipCode) {
        userService.updateUser(id, firstName, lastName, dateOfBirth, email, mobile, street, city, state, zipCode);
        return "User updated.";
    }

    @RequestMapping(value = "changeUserPassword")
    @ResponseBody
    public String changeUserPassword(@RequestParam long id,
                                     @RequestParam String password) {
        userService.changeUserPassword(id, password);
        return "User password changed.";
    }

    @RequestMapping(value = "changeUserRole")
    @ResponseBody
    public String changeUserRole(@RequestParam long id,
                                 @RequestParam User.Role role) {
        userService.changeUserRole(id, role);
        return "User role changed.";
    }

    @RequestMapping(value = "changeUserStatus")
    @ResponseBody
    public String changeUserStatus(@RequestParam long id,
                                   @RequestParam Status status) {
        userService.changeUserStatus(id, status);
        return "User status changed.";
    }

    @RequestMapping(value = "deleteUser")
    @ResponseBody
    public String deleteUser(@RequestParam long id) {
        userService.deleteUser(id);
        return "User deleted";
    }

    @RequestMapping(value = "welcome")
    @ResponseBody
    public String welcome() {
        return "Welcome to KhidaShamlao, Visitor!";
    }
}
