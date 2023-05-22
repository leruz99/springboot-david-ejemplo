package com.example.crud.controler;

import com.example.crud.entity.User;
import com.example.crud.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserControler {

    private final UserService userService;

    public UserControler(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/new")
    public User seveUser(@RequestBody User user){
        return userService.saveUser(user);
    }
    @GetMapping("/{name}")
    public User getUserByName(@PathVariable String name){
        return userService.getUser(name);
    }
    @PutMapping("/{name}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable String name){
        Optional<User> user1 = Optional.ofNullable(userService.getUser(name));
        if (user1.isPresent()){
            User userDB = user1.get();
            userDB.setName(user.getName());
            userDB.setPassword(user.getPassword());
            return ResponseEntity.status(HttpStatus.CREATED).body(userService.updateUser(userDB));
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/all")
    public List<User> getAllUser(){
         return userService.getAllUser();
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }

}
