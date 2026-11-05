package com.magioli.recipesharing.auth;

import com.magioli.recipesharing.auth.dto.LoginRequestDto;
import com.magioli.recipesharing.auth.dto.LoginResponseDto;
import com.magioli.recipesharing.auth.dto.RecipeSharingUserRequestRequestDto;
import com.magioli.recipesharing.entities.RecipeSharingUser;
import com.magioli.recipesharing.security.util.JwtUtil;
import com.magioli.recipesharing.user.dto.RecipeSharingUserDto;
import com.magioli.recipesharing.user.service.RecipeSharingUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final RecipeSharingUserService userService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody @Validated LoginRequestDto loginRequestDto) {
        Authentication authentication = convertDtoToAuthentication(loginRequestDto);
        authentication = authenticationManager.authenticate(authentication);
        RecipeSharingUser user = (RecipeSharingUser) authentication.getPrincipal();
        String token = jwtUtil.generateToken(authentication);
        LoginResponseDto response = new LoginResponseDto(
                new RecipeSharingUserDto(user.getUsername(), user.getEmail(), user.getRecipes()),
                token);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<RecipeSharingUserDto> register(@RequestBody @Validated RecipeSharingUserRequestRequestDto userDto) {
        RecipeSharingUserDto createdUser = userService.create(userDto);
        return ResponseEntity.ok(createdUser);
    }
    private Authentication convertDtoToAuthentication(LoginRequestDto loginRequestDto) {
        return new UsernamePasswordAuthenticationToken(loginRequestDto.email(), loginRequestDto.password());
    }
}
