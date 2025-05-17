package com.sneakersEcomerce.sneakersEcomerceBackend.auth;

import com.sneakersEcomerce.sneakersEcomerceBackend.user.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResgisterRequest {
    String name;
    String lastname;
    String username;
    Integer dni;
    String email;
    String password;
    UserType userType;
}
