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

    @PostMapping(value = "")
    @ResponseBody
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        userService.saveUser(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    @ResponseBody
    public User retrieveUser(@PathVariable long id) {
        return userService.retrieveUser(id);
    }

    @GetMapping(value = "")
    @ResponseBody
    public Iterable<User> retrieveAllUsers() {
        return userService.retrieveAllUsers();
    }

    @PutMapping(value = "updateUserPassword/")
    @ResponseBody
    public ResponseEntity<User> updateUserPassword(@RequestBody User user) {
        UserMapper userMapper = new UserMapper(userService.retrieveUser(user.getId()), user);
        user = userMapper.updatePassword();
        userService.saveUser(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @PutMapping(value = "updateUserInfo/")
    @ResponseBody
    public ResponseEntity<User> updateUserInfo(@RequestBody User user) {
        UserMapper userMapper = new UserMapper(userService.retrieveUser(user.getId()), user);
        user = userMapper.updateInfo();
        userService.saveUser(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @PutMapping(value = "updateUserInfoAdmin/")
    @ResponseBody
    public ResponseEntity<User> updateUserInfoAdmin(@RequestBody User user) {
        UserMapper userMapper = new UserMapper(userService.retrieveUser(user.getId()), user);
        user = userMapper.updateInfoAdmin();
        userService.saveUser(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @PutMapping(value = "deleteUser/{id}")
    @ResponseBody
    public String deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
        return "User deleted";
    }

    @DeleteMapping(value = "{id}")
    @ResponseBody
    public String deleteUserPermanently(@PathVariable long id) {
        userService.deleteUserPermanently(id);
        return "User deleted";
    }

    @RequestMapping(value = "welcome")
    @ResponseBody
    public String welcome() {
        return "Welcome to Users, Visitor!";
    }
}
