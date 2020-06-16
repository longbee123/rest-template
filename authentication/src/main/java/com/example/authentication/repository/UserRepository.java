package com.example.authentication.repository;

import com.example.authentication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * rest-template-demo
 *
 * @author longtcs
 * @created_at 16/06/2020 - 11:12
 * @created_by longtcs
 * @since 16/06/2020
 */
public interface UserRepository extends JpaRepository<User,Integer> {
        Optional<User> findByUsername(String name);
}
