package com.rb.ppm.application.rest;

import com.rb.ppm.application.dto.AuthRq;
import com.rb.ppm.application.dto.AuthRs;
import com.rb.ppm.core.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthService authService;


    @PostMapping("/login")
    public ResponseEntity<AuthRs> login(@RequestBody AuthRq authRq) {
        try {
            return ResponseEntity.ok().body(authService.authenticate(authRq));
        } catch (Exception e) {
            e.getStackTrace();
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping("/register")
    public ResponseEntity<Boolean> register(@RequestBody AuthRq authRq) {
        try {
            return ResponseEntity.ok().body(authService.createOfficer(authRq));
        } catch (Exception e) {
            e.getStackTrace();
            return ResponseEntity.notFound().build();
        }
    }


}
