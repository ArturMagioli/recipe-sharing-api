package com.magioli.recipesharing.user.dto;

import java.util.List;

public record RecipeSharingUserResponseDto(Long id, String username, String email, List<Long> recipes) {
}
