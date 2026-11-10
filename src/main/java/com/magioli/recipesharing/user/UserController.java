package com.magioli.recipesharing.user;

import com.magioli.recipesharing.user.dto.RecipeSharingUserDto;
import com.magioli.recipesharing.user.dto.RecipeSharingUserResponseDto;
import com.magioli.recipesharing.user.service.RecipeSharingUserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final RecipeSharingUserService userService;

    @GetMapping
    public ResponseEntity<?> findUsers(@RequestParam(name = "email", required = false) String email) {
        if (email == null) {
            List<RecipeSharingUserResponseDto> users = userService.findAll();
            return ResponseEntity.ok(users);
        }
        RecipeSharingUserResponseDto user = userService.findByEmail(email);
        return ResponseEntity.ok(user);
    }

    @PutMapping
    public ResponseEntity<String> updateUser(Authentication authentication, @RequestBody @Validated RecipeSharingUserDto updatedUser) {
        RecipeSharingUserDto userAuth = (RecipeSharingUserDto) authentication.getPrincipal();
        boolean isUpdated = userService.updateByEmail(updatedUser, userAuth.email());
        if (isUpdated) {
            return ResponseEntity.ok("User updated successfully!");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to update resource, please try again later.");
        }
    }

    @DeleteMapping
    public ResponseEntity<String> deleteUser(Authentication authentication) {
        RecipeSharingUserDto userAuth = (RecipeSharingUserDto) authentication.getPrincipal();
        userService.deleteByEmail(userAuth.email());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("User deleted successfully!");
    }
}
