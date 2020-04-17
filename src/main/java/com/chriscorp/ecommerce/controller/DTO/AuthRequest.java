package com.chriscorp.ecommerce.controller.DTO;

import lombok.Data;

@Data
public class AuthRequest {

    private String username;
    private String password;
    private String token;


}
