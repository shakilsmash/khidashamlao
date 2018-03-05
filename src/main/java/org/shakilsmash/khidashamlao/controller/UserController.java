package org.shakilsmash.khidashamlao.controller;

import org.shakilsmash.khidashamlao.model.User;
import org.shakilsmash.khidashamlao.service.UserService;
import org.shakilsmash.khidashamlao.viewModel.UserVM;
import org.shakilsmash.khidashamlao.viewModelUtility.UserVMUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
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
     * @param userVM is the object that is initiated with the information from the input JSON
     * @return the ResponseEntity with status 200 (OK) and with user in the body, or with status 404 (Not Found)
     */
    @PostMapping(value = "")
    public ResponseEntity<User> createUser(@Valid @RequestBody UserVM userVM) {
        User result = userService.save(UserVMUtility.mapToUser(userVM));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * GET /user/:id : Get a user from the database with the given id
     *
     * @param id specifies the id of the object of the user that is to be shown from the database
     * @return Returns and displays all the information of the fetched user in JSON format.
     */
    @GetMapping(value = "{id}")
    public ResponseEntity<User>  retrieveUser(@PathVariable long id) {
        User user = userService.retrieveUser(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    /**
     * GET /user/ : Get all the users from the database
     *
     * @return Returns and displays all the information of the fetched users in JSON format.
     */
    @GetMapping(value = "")
    public /* use ResponseEntity here */Iterable<User> retrieveAllUsers() {
        //return new ResponseEntity<User>(userService.retrieveAllUsers(), HttpStatus.OK);
        return userService.retrieveAllUsers();
    }

//    /**
//     * PUT /user/updateUserPassword : Updates user password.
//     *
//     * @param user is the object that is initiated with the information from the input JSON
//     * @return the ResponseEntity with status 200 (OK) and with user in the body, or with status 404 (Not Found)
//     */
//    @PutMapping(value = "updateUserPassword/")
//    public ResponseEntity<User> updateUserPassword(@RequestBody User user) {
//        UserMapper userMapper = new UserMapper(userService.retrieveUser(user.getId()), user);
//        user = userMapper.updatePassword();
//        userService.save(user);
//        return new ResponseEntity<User>(user, HttpStatus.OK);
//    }
//
//    /**
//     * PUT /user/updateUserInfo : Updates user's basic info.
//     *
//     * @param user is the object that is initiated with the information from the input JSON
//     * @return the ResponseEntity with status 200 (OK) and with user in the body, or with status 404 (Not Found)
//     */
//    @PutMapping(value = "updateUserInfo")
//    public ResponseEntity<User> updateUserInfo(@RequestBody User user) {
//        UserMapper userMapper = new UserMapper(userService.retrieveUser(user.getId()), user);
//        user = userMapper.updateInfo();
//        userService.save(user);
//        return new ResponseEntity<User>(user, HttpStatus.OK);
//    }
//
//    /**
//     * PUT /user/updateUserPassword : Updates user info rom the admin's side.
//     *
//     * @param user is the object that is initiated with the information from the input JSON
//     * @return the ResponseEntity with status 200 (OK) and with user in the body, or with status 404 (Not Found)
//     */
//    @PutMapping(value = "updateUserInfoAdmin/")
//    public ResponseEntity<User> updateUserInfoAdmin(@RequestBody User user) {
//        UserMapper userMapper = new UserMapper(userService.retrieveUser(user.getId()), user);
//        user = userMapper.updateInfoAdmin();
//        userService.save(user);
//        return new ResponseEntity<User>(user, HttpStatus.OK);
//    }

    /**
     * PUT /user/:id : Soft deletes a user.
     *
     * @param id is the id of the object that is to be deleted
     * @return A success message
     */
    @PutMapping(value = "deleteUser/{id}")
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
    public String deleteUserPermanently(@PathVariable long id) {
        userService.deleteUserPermanently(id);
        return "User deleted";
    }

    @PutMapping(value = "testupdate")
    public ResponseEntity<User> testupdate(@Valid @RequestBody User user) {
        //log.debug("REST request to update an User : {}", user);
        if (user.getId() == 0) {
            // TODO : need to implement a message alert utility which will be sent with the ResponseEntity
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            User result = userService.save(user);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    /**
     * GET /user/welcome : Shows a welcome message
     *
     * @return A success message
     */
    @RequestMapping(value = "welcome")
    public String welcome() {
        return "Welcome to Users, Visitor!";
    }
}
