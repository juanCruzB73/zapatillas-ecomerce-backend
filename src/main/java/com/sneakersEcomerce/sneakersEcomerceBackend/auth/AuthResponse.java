package com.sneakersEcomerce.sneakersEcomerceBackend.auth;

import com.sneakersEcomerce.sneakersEcomerceBackend.user.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthResponse {
    String token;
    Integer userId;
    String username;
    UserType userType;
}
