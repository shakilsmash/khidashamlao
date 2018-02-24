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

    /**
     * POST /user : Create a new user to be inserted into the database
     *
     * @param user is the object that is initiated with the information from the input JSON
     * @return the ResponseEntity with status 200 (OK) and with user in the body, or with status 404 (Not Found)
     */
    @PostMapping(value = "")
    @ResponseBody
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        userService.saveUser(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    /**
     * GET /user/:id : Get a user from the database with the given id
     *
     * @param id specifies the id of the object of the user that is to be shown from the database
     * @return Returns and displays all the information of the fetched user in JSON format.
     */
    @GetMapping(value = "{id}")
    @ResponseBody
    public User retrieveUser(@PathVariable long id) {
        return userService.retrieveUser(id);
    }

    /**
     * GET /user/ : Get all the users from the database
     *
     * @return Returns and displays all the information of the fetched users in JSON format.
     */
    @GetMapping(value = "")
    @ResponseBody
    public Iterable<User> retrieveAllUsers() {
        return userService.retrieveAllUsers();
    }

    /**
     * PUT /user/updateUserPassword : Updates user password.
     *
     * @param user is the object that is initiated with the information from the input JSON
     * @return the ResponseEntity with status 200 (OK) and with user in the body, or with status 404 (Not Found)
     */
    @PutMapping(value = "updateUserPassword/")
    @ResponseBody
    public ResponseEntity<User> updateUserPassword(@RequestBody User user) {
        UserMapper userMapper = new UserMapper(userService.retrieveUser(user.getId()), user);
        user = userMapper.updatePassword();
        userService.saveUser(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    /**
     * PUT /user/updateUserInfo : Updates user's basic info.
     *
     * @param user is the object that is initiated with the information from the input JSON
     * @return the ResponseEntity with status 200 (OK) and with user in the body, or with status 404 (Not Found)
     */
    @PutMapping(value = "updateUserInfo/")
    @ResponseBody
    public ResponseEntity<User> updateUserInfo(@RequestBody User user) {
        UserMapper userMapper = new UserMapper(userService.retrieveUser(user.getId()), user);
        user = userMapper.updateInfo();
        userService.saveUser(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    /**
     * PUT /user/updateUserPassword : Updates user info rom the admin's side.
     *
     * @param user is the object that is initiated with the information from the input JSON
     * @return the ResponseEntity with status 200 (OK) and with user in the body, or with status 404 (Not Found)
     */
    @PutMapping(value = "updateUserInfoAdmin/")
    @ResponseBody
    public ResponseEntity<User> updateUserInfoAdmin(@RequestBody User user) {
        UserMapper userMapper = new UserMapper(userService.retrieveUser(user.getId()), user);
        user = userMapper.updateInfoAdmin();
        userService.saveUser(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    /**
     * PUT /user/:id : Soft deletes a user.
     *
     * @param id is the id of the object that is to be deleted
     * @return A success message
     */
    @PutMapping(value = "deleteUser/{id}")
    @ResponseBody
    public String deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
        return "User deleted";
    }

    /**
     * DELETE /user/:id : Hard deletes a user.
     *
     * @param id is the id of the object that is to be deleted
     * @return A success message
     */
    @DeleteMapping(value = "{id}")
    @ResponseBody
    public String deleteUserPermanently(@PathVariable long id) {
        userService.deleteUserPermanently(id);
        return "User deleted";
    }

    /**
     * GET /user/welcome : Shows a welcome message
     *
     * @return A success message
     */
    @RequestMapping(value = "welcome")
    @ResponseBody
    public String welcome() {
        return "Welcome to Users, Visitor!";
    }
}
