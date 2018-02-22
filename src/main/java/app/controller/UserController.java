package app.controller;

import app.model.Status;
import app.model.User;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.Date;

@Controller
@RequestMapping(value = "user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "createUser")
    @ResponseBody
    public String createUser(@Valid User user) {
        userService.saveUser(user);
        return "Added to the database!";
    }

    @GetMapping(value = "retrieveUser/{id}")
    @ResponseBody
    public User retrieveUser(@PathVariable long id) {
        return userService.retrieveUser(id);
    }

    @GetMapping(value = "retrieveAllUsers")
    @ResponseBody
    public Iterable<User> retrieveAllUsers() {
        return userService.retrieveAllUsers();
    }

    @PutMapping(value = "updateUser/{id}")
    @ResponseBody
    public String updateUser(User user) {
        userService.saveUser(user);
        return "User updated.";
    }

    @DeleteMapping(value = "deleteUser")
    @ResponseBody
    public String deleteUser(@RequestParam long id) {
        userService.deleteUser(id);
        return "User deleted";
    }

    @RequestMapping(value = "welcome")
    @ResponseBody
    public String welcome() {
        return "Welcome to Users, Visitor!";
    }
}
