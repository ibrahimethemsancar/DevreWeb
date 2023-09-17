package com.devre.devreweb.controllers;

import com.devre.devreweb.entities.User;
import com.devre.devreweb.services.abstracts.IUserService;
import com.devre.devreweb.services.requests.CreateUserRequest;
import com.devre.devreweb.services.responses.UserDetailResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController{
    private IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<List<User>> getAllUsers() throws  Exception{
        try {
            return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/create")
    public ResponseEntity createUser(@RequestBody CreateUserRequest request) throws Exception {
        userService.createUser(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public  ResponseEntity<User> getOneUser(@PathVariable Long userId){
       return  new ResponseEntity<>(userService.getOneUserById(userId), HttpStatus.OK);
    }

    @PutMapping("/{userId}")
    public User updateOneUser(@PathVariable Long userId, @RequestBody CreateUserRequest request){
        return null;
    }
}
