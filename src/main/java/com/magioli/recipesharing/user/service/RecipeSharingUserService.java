package com.magioli.recipesharing.user.service;

import com.magioli.recipesharing.auth.dto.RegisterRequestDto;
import com.magioli.recipesharing.user.dto.RecipeSharingUserDto;
import com.magioli.recipesharing.user.dto.RecipeSharingUserResponseDto;

import java.util.List;

public interface RecipeSharingUserService {

    RecipeSharingUserDto create(RegisterRequestDto userDto);

    List<RecipeSharingUserResponseDto> findAll();

    RecipeSharingUserResponseDto findByEmail(String email);

    boolean updateByEmail(RecipeSharingUserDto userDto, String email);

    void deleteByEmail(String email);
}
