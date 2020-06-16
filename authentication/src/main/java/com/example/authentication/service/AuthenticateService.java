package com.example.authentication.service;

import com.example.authentication.entity.User;
import com.example.authentication.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * rest-template-demo
 *
 * @author longtcs
 * @created_at 16/06/2020 - 11:11
 * @created_by longtcs
 * @since 16/06/2020
 */
@Service
public class AuthenticateService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user){
        User user1 = new User();
        user1.setUsername(user.getUsername());
        user1.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12)));
        return userRepository.save(user1);
    }

}
