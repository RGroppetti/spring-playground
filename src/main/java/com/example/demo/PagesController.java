package com.example.demo;

import org.springframework.web.bind.annotation.*;


@RestController

public class PagesController {
    private final UserRepository repository;
    public PagesController(UserRepository repository){
        this.repository = repository;
    }

    @GetMapping("/users")

    public Iterable<User> getUsers(){
        return this.repository.findAll();
    }

    @PostMapping("/users")
    public User create(@RequestBody User user){
        return this.repository.save(user);
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable("id") String id) {
        return this.repository.findByUserId(Long.parseLong(id));
    }
    @PatchMapping("/users/{id}")
    public User updateUser(@PathVariable("id") String id){
        return this.repository.updateUserById(Long.parseLong(id));
    }
}

