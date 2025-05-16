package com.sneakersEcomerce.sneakersEcomerceBackend.auth;

import org.hibernate.usertype.UserType;

public class AuthResponse {
    String token;
    Integer userId;
    String username;
    UserType userType;
}
