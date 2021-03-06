package org.shakilsmash.khidashamlao.web.controller;

import org.shakilsmash.khidashamlao.domain.User;
import org.shakilsmash.khidashamlao.service.UserService;
import org.shakilsmash.khidashamlao.util.PaginationUtil;
import org.shakilsmash.khidashamlao.vm.UserVM;
import org.shakilsmash.khidashamlao.vmutility.UserVMUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
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
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;
import java.util.List;

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
        User user = userService.save(UserVMUtility.mapToUser(userVM));
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    /**
     * GET /user/:id : Get a user from the database with the given id
     *
     * @param id specifies the id of the object of the user that is to be shown from the database
     * @return Returns and displays all the information of the fetched user in JSON format.
     */
    @GetMapping(value = "{id}")
    public ResponseEntity<User>  retrieveUser(@PathVariable long id) {
        User user = userService.retrieve(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    /**
     * GET /user/ : Get all the users from the database
     *
     * @return Returns and displays all the information of the fetched users in JSON format.
     */
    @GetMapping(value = "")
    public ResponseEntity<List<User>> findAll(Pageable pageable) {
        //log.debug("REST request to get a page of Users");
        Page<User> page = userService.retrieveAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "localhost:8080/user");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    @PutMapping(value = "updateUserPassword/{id}")
    public ResponseEntity<User> updateUserPassword(@PathVariable long id, WebRequest request) {

        String password = request.getParameter("password");

        User user = userService.retrieve(id);
        user.setPassword(password);
        userService.save(user);

        userService.updatePassword(id, password);
        return new ResponseEntity<>(userService.retrieve(id), HttpStatus.OK);
    }

//    /**
//     * PUT /user/updateUserPassword : Updates user password.
//     *
//     * @param user is the object that is initiated with the information from the input JSON
//     * @return the ResponseEntity with status 200 (OK) and with user in the body, or with status 404 (Not Found)
//     */
//    @PutMapping(value = "updateUserPassword/")
//    public ResponseEntity<User> updateUserPassword(@RequestBody User user) {
//        UserMapper userMapper = new UserMapper(userService.retrieve(user.getId()), user);
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
//        UserMapper userMapper = new UserMapper(userService.retrieve(user.getId()), user);
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
//        UserMapper userMapper = new UserMapper(userService.retrieve(user.getId()), user);
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
    @PutMapping(value = "delete/{id}")
    public String deleteUser(@PathVariable long id) {
        userService.delete(id);
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
        userService.deletePermanently(id);
        return "User deleted";
    }

    /**
     * GET /user/welcome : Shows a welcome message
     *
     * @return A success message
     */
    @GetMapping(value = "welcome")
    public String welcome() {
        return "Welcome to Users, Visitor!";
    }
}
