package com.dev.expensetracker.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dev.expensetracker.entity.JwtResponse;
import com.dev.expensetracker.entity.LoginModel;
import com.dev.expensetracker.entity.User;
import com.dev.expensetracker.entity.UserModel;
import com.dev.expensetracker.security.CustomUserDetailsService;
import com.dev.expensetracker.service.IUserService;
import com.dev.expensetracker.util.JwtTokenUtil;

@RestController
public class AuthController {

    @Autowired
    private IUserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginModel loginModel) throws Exception {

        authenticate(loginModel.getEmail(), loginModel.getPassword());

        // Generated JWT Token
        final UserDetails userDetails = customUserDetailsService.loadUserByUsername(loginModel.getEmail());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return new ResponseEntity<JwtResponse>(new JwtResponse(token), HttpStatus.OK);
    }

    private void authenticate(String email, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        } catch (DisabledException e) {
            throw new Exception("User Disabled!");
        } catch (BadCredentialsException e) {
            throw new Exception("Bad Credentials!");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<User> save(@Valid @RequestBody UserModel user) {

        return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);
    }
}
