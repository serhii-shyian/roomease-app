package com.example.roomease.repository.user;

import com.example.roomease.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long>,
        JpaSpecificationExecutor<User> {
    @Query("from User u left join fetch u.roles where u.email = :email")
    Optional<User> findByEmail(String email);

    @Query("from User u left join fetch u.roles where u.username = :username")
    Optional<User> findByUsername(String username);
}
