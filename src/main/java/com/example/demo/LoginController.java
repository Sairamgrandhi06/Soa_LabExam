package com.example.demo;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class LoginController {

    private static final String DEMO_USERNAME = "admin";
    private static final String DEMO_PASSWORD = "password123";
   
    @PostMapping("/login-static")
    public ResponseEntity<Map<String, String>> login(
            @RequestBody(required = false) Map<String, String> data) {

        if (data == null) {
            return ResponseEntity.badRequest()
                    .body(Map.of("message", "Request body is required"));
        }

        String username = data.get("username");
        String password = data.get("password");

        if (DEMO_USERNAME.equals(username) && DEMO_PASSWORD.equals(password)) {
            return ResponseEntity.ok(
                    Map.of("message", "Authentication Successful"));
        }

        return ResponseEntity.status(401)
                .body(Map.of("message", "Authentication Failed"));
    }
}
