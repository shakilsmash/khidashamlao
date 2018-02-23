package app.controller;

import app.model.User;
import app.service.UserService;
import app.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

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
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        userService.saveUser(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
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

    @PutMapping(value = "updateUser/")
    @ResponseBody
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        UserMapper userMapper = new UserMapper(userService.retrieveUser(user.getId()));
        user = userMapper.updatePassword(user.getPassword());
        userService.saveUser(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
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
