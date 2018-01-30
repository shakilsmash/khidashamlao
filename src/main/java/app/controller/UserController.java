package app.controller;

import app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import app.service.UserService;

import javax.jws.soap.SOAPBinding;
import java.util.Date;

@Controller
@RequestMapping(value ="/")
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

    @RequestMapping(value = "updateUser")
    @ResponseBody
    public String updateUser(@RequestParam String firstName,
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


    @RequestMapping(value = "welcome")
    @ResponseBody
    public String welcome() {
        return "Welcome to KhidaShamlao, Visitor!";
    }
}
