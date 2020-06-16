package com.example.authentication.model;

import lombok.Data;

/**
 * rest-template-demo
 *
 * @author longtcs
 * @created_at 16/06/2020 - 15:41
 * @created_by longtcs
 * @since 16/06/2020
 */
@Data
public class AuthenticationReq {
    private String username;
    private String password;
}
