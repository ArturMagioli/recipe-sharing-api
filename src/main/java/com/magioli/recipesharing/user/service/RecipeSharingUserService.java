package com.magioli.recipesharing.user.service;

import com.magioli.recipesharing.auth.dto.RecipeSharingUserRequestRequestDto;
import com.magioli.recipesharing.user.dto.RecipeSharingUserDto;

public interface RecipeSharingUserService {

    RecipeSharingUserDto create(RecipeSharingUserRequestRequestDto userDto);
}
