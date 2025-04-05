package com.Autentification.Autentification.service;

import com.Autentification.Autentification.dto.LoginRequest;
import com.Autentification.Autentification.dto.LoginResponse;
import com.Autentification.Autentification.dto.RegisterRequest;
import com.Autentification.Autentification.model.User;
import com.Autentification.Autentification.repository.UserRepository;
import com.Autentification.Autentification.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public LoginResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        LoginResponse  loginResponse=new LoginResponse();
        loginResponse.setToken(jwtToken);
        return loginResponse;
    }

    public void register(RegisterRequest request) {
        var user = new User(
                request.getFirstname(),
                request.getLastname(),
                request.getEmail(),
                passwordEncoder.encode(request.getPassword()),
                request.getRole()
        );

        userRepository.save(user);

    }
}