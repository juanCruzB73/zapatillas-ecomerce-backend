package com.sneakersEcomerce.sneakersEcomerceBackend.auth;

import com.sneakersEcomerce.sneakersEcomerceBackend.jwt.JwtService;
import com.sneakersEcomerce.sneakersEcomerceBackend.user.UserModel;
import com.sneakersEcomerce.sneakersEcomerceBackend.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public AuthResponse login(LoginRequest loginRequest) {
        return null;
    }

    public AuthResponse register(ResgisterRequest registerRequest) {
        UserModel user = UserModel.builder()
                .username(registerRequest.getUsername())
                .name(registerRequest.getName())
                .lastname(registerRequest.getLastname())
                .dni(registerRequest.getDni())
                .email(registerRequest.getEmail())
                .userType(registerRequest.getUserType())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .build();
        userRepository.save(user);
        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .username(user.getUsername())
                .userId(user.getUserId())
                .userType(user.getUserType())
                .build();
    }
}
