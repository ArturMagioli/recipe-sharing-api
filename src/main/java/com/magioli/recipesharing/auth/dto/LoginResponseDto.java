package com.magioli.recipesharing.auth.dto;

import com.magioli.recipesharing.user.dto.RecipeSharingUserDto;

public record LoginResponseDto(RecipeSharingUserDto userDto, String token) {
}
