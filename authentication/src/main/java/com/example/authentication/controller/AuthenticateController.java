package com.example.authentication.controller;

import com.example.authentication.entity.User;
import com.example.authentication.model.AuthenticationReq;
import com.example.authentication.security.JwtTokenUtil;
import com.example.authentication.service.AuthenticateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * rest-template-demo
 *
 * @author longtcs
 * @created_at 16/06/2020 - 11:11
 * @created_by longtcs
 * @since 16/06/2020
 */

@RestController
@RequestMapping("/user")
public class AuthenticateController {

    @Autowired
    private AuthenticateService authenticateService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody User user){
        return ResponseEntity.ok(authenticateService.createUser(user));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<?> login(@RequestBody AuthenticationReq req) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenUtil.generateToken((UserDetails) authentication.getPrincipal());
        return ResponseEntity.ok(token);
    }

}
