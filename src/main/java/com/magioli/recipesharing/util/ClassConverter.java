package com.magioli.recipesharing.util;

import com.magioli.recipesharing.entities.RecipeSharingUser;
import com.magioli.recipesharing.user.dto.RecipeSharingUserDto;
import org.springframework.stereotype.Component;

@Component
public class ClassConverter {

    public RecipeSharingUserDto convertUserToDto(RecipeSharingUser user) {
        return new RecipeSharingUserDto(user.getUsername(), user.getEmail());
    }
}
