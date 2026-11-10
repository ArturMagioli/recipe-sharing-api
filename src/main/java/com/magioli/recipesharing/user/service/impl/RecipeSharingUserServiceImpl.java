package com.magioli.recipesharing.user.service.impl;

import com.magioli.recipesharing.auth.dto.RegisterRequestDto;
import com.magioli.recipesharing.entities.RecipeSharingUser;
import com.magioli.recipesharing.exception.custom.ResourceNotFoundException;
import com.magioli.recipesharing.repositories.RecipeSharingUserRepository;
import com.magioli.recipesharing.user.dto.RecipeSharingUserDto;
import com.magioli.recipesharing.user.dto.RecipeSharingUserResponseDto;
import com.magioli.recipesharing.user.service.RecipeSharingUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.password.CompromisedPasswordDecision;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.password.HaveIBeenPwnedRestApiPasswordChecker;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RecipeSharingUserServiceImpl implements RecipeSharingUserService {

    private final HaveIBeenPwnedRestApiPasswordChecker passwordChecker;
    private final PasswordEncoder passwordEncoder;
    private final RecipeSharingUserRepository userRepository;

    @Override
    public List<RecipeSharingUserResponseDto> findAll() {
        List<RecipeSharingUser> users = userRepository.findAll();
        return users.stream().map(this::convertUserToResponseDto).toList();
    }

    @Override
    public RecipeSharingUserResponseDto findByEmail(String email) {
        RecipeSharingUser user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with email: " + email));
        return convertUserToResponseDto(user);
    }

    @Transactional
    @Override
    public RecipeSharingUserDto create(RegisterRequestDto userDto) {
        String password = userDto.password();
        CompromisedPasswordDecision decision = passwordChecker.check(password);
        if (decision.isCompromised()) {
            throw new BadCredentialsException("Password is too weak. A good password must have capital and special chars.");
        }
        String email = userDto.email();
        Optional<RecipeSharingUser> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            throw new BadCredentialsException("Email is already used");
        }
        String encodedPassword = passwordEncoder.encode(password);
        RecipeSharingUser newUser = new RecipeSharingUser(userDto.username(), encodedPassword, email);
        userRepository.save(newUser);
        return convertUserToDto(newUser);
    }

    @Transactional
    @Override
    public boolean updateByEmail(RecipeSharingUserDto userDto, String email) {
        RecipeSharingUser user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with email: " + email));
        BeanUtils.copyProperties(userDto, user);
        return true;
    }

    @Transactional
    @Override
    public void deleteByEmail(String email) {
        userRepository.deleteByEmail(email);
    }

    private RecipeSharingUserDto convertUserToDto(RecipeSharingUser user) {
        return new RecipeSharingUserDto(user.getUsername(), user.getEmail());
    }

    private RecipeSharingUserResponseDto convertUserToResponseDto(RecipeSharingUser user) {
        List<Long> recipeIds = user.getRecipes().stream().map(recipe -> recipe.getId()).toList();
        return new RecipeSharingUserResponseDto(user.getId(), user.getUsername(), user.getEmail(), recipeIds);
    }
}
