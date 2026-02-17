package com.MAJORPROJECT.LOVABLE.controllers;

import com.MAJORPROJECT.LOVABLE.dto.auth.AuthResponse;
import com.MAJORPROJECT.LOVABLE.dto.auth.LoginRequest;
import com.MAJORPROJECT.LOVABLE.dto.auth.SignUpRequest;
import com.MAJORPROJECT.LOVABLE.dto.auth.UserProfileResponse;
import com.MAJORPROJECT.LOVABLE.services.AuthService;
import com.MAJORPROJECT.LOVABLE.services.UserService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@RestController//(get,put,patch,delte//crud operations)
public class AuthController {


     AuthService authService;//loose coupling
     UserService userService;
    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signup(@RequestBody SignUpRequest request){

        return ResponseEntity.ok(authService.signup(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody  LoginRequest request){
        return ResponseEntity.ok(authService.login(request));
    }

    @GetMapping("/me")
    public ResponseEntity<UserProfileResponse> getProfile() {
        Long userId = 1L;
        return ResponseEntity.ok(userService.getProfile(userId));
    }

}
