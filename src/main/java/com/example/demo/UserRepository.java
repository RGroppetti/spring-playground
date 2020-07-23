package com.example.demo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {

        @Query(value="SELECT * FROM users WHERE id = :id", nativeQuery=true)
        User findByUserId(Long id);
        @Query(value = "PATCH * From users WHERE id = :id", nativeQuery = true)
        User updateUserById(Long id);
}
