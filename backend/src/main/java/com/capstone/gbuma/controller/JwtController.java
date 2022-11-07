package com.capstone.gbuma.controller;

import com.capstone.gbuma.entity.JwtResponse;
import com.capstone.gbuma.entity.LoginRequest;
import com.capstone.gbuma.helper.JwtUtil;
import com.capstone.gbuma.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class JwtController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtUtil jwtUtil;
    @PostMapping("/token")
    public ResponseEntity<?> generateToken(@RequestBody LoginRequest loginRequest) throws Exception{

        try {
            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getCustomer_number(), loginRequest.getPassword()));

        }
        catch(UsernameNotFoundException ex)
        {
            ex.printStackTrace();
            throw new Exception("Bad Credentials");
        }
        catch(BadCredentialsException e) {
            e.printStackTrace();
            System.out.println("Erroer here"+loginRequest.getCustomer_number()+" "+loginRequest.getPassword());
//            throw new Exception("Bad Credentials");
            return ResponseEntity.ok(null);
        }
        UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(loginRequest.getCustomer_number());
        String token = this.jwtUtil.generateToken(userDetails);
        System.out.println("JWT: " + token);

        return ResponseEntity.ok(new JwtResponse(token));

    }

}