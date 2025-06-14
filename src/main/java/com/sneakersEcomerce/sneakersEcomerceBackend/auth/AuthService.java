package com.sneakersEcomerce.sneakersEcomerceBackend.auth;

import com.sneakersEcomerce.sneakersEcomerceBackend.jwt.JwtService;
import com.sneakersEcomerce.sneakersEcomerceBackend.user.UserModel;
import com.sneakersEcomerce.sneakersEcomerceBackend.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest loginRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword()));
        UserModel user=userRepository.findByUsername(loginRequest.getUsername()).orElseThrow();
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("email", user.getEmail());
        extraClaims.put("userType", user.getUserType());
        extraClaims.put("userId",user.getUserId());
        String token = jwtService.getToken(extraClaims,user);
        return AuthResponse.builder()
                .token(token)
                .username(user.getUsername())
                .userId(user.getUserId())
                .userType(user.getUserType())
                .build();
    }

    public AuthResponse register(ResgisterRequest registerRequest) {
        UserModel user = UserModel.builder()
                .username(registerRequest.getUsername())
                .name(registerRequest.getName())
                .lastname(registerRequest.getLastname())
                .dni(registerRequest.getDni())
                .email(registerRequest.getEmail())
                .userType("user")
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .build();
        userRepository.save(user);
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("email", user.getEmail());
        extraClaims.put("userType", user.getUserType());
        extraClaims.put("userId",user.getUserId());
        return AuthResponse.builder()
                .token(jwtService.getToken(extraClaims,user))
                .username(user.getUsername())
                .userId(user.getUserId())
                .userType(user.getUserType())
                .build();
    }
}
