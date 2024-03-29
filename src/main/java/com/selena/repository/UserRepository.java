package com.selena.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.selena.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    boolean existsByUsername(String username);
    User findByUsername(String username);
    @Query("SELECT u FROM User u WHERE u.username = :username")
    public User getUserByUsername(@Param("username") String username);

}
