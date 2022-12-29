package com.woquiz.user;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.woquiz.config.security.JwtUtil;

@RestController
public class UserController {

    private final AuthenticationManager manager;
    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;

    public UserController(AuthenticationManager manager, UserDetailsService userDetailsService, JwtUtil jwtUtil) {
        this.manager = manager;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(
            @RequestBody AuthenticationRequest request
    ){
        manager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(),request.getEmail()));
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
        return userDetails != null ?
                ResponseEntity.ok(jwtUtil.generateToken(userDetails)):
                ResponseEntity.badRequest().body("failed authentication");
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok("hello world");
    }
}
