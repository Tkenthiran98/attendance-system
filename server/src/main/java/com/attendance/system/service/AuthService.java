package com.attendance.system.service;

import com.attendance.system.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService implements UserDetailsService {

    @Value("${jwt.secret}")
    private String secretKey;

    private Map<String, String> userCredentials = new HashMap<>();

    @PostConstruct
    protected void init() {
        loadUserCredentials();
    }

    private void loadUserCredentials() {
        try {
            byte[] bytes = FileCopyUtils.copyToByteArray(getClass().getClassLoader().getResourceAsStream("users.txt"));
            String fileContent = new String(bytes, StandardCharsets.UTF_8);
            String[] lines = fileContent.split("\\r?\\n");

            for (String line : lines) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    userCredentials.put(parts[0].trim(), parts[1].trim());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load user credentials from file", e);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String password = userCredentials.get(username);
        if (password == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return org.springframework.security.core.userdetails.User
                .withUsername(username)
                .password(password)
                .roles("USER")
                .build();
    }

    public String authenticate(User user) {
        UserDetails userDetails = loadUserByUsername(user.getUsername());
        if (userDetails.getPassword().equals(user.getPassword())) {
            return "Bearer " + generateToken(userDetails.getUsername());
        }
        return null;
    }

    private String generateToken(String username) {
        // Implement your JWT token generation logic here
        return "jwt.token"; // Dummy implementation
    }
}
