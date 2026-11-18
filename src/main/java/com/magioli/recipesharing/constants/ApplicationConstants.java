package com.magioli.recipesharing.constants;

import java.util.Collections;
import java.util.List;

public class ApplicationConstants {

    public ApplicationConstants() {
        throw new RuntimeException("You cannot instantiate this class.");
    }

    public static final String DEFAULT_JWT_SECRET = "XwDCtNcAEiCxDQQui-ASw582NZ3FSKvIsqulO7K_vkY";
    public static final String AUTHORIZATION_TOKEN_HEADER = "Authorization";

    public static final List<String> standardUnits = Collections.unmodifiableList(List.of("g", "kg", "ml", "l",
            "pc", "tsp", "tbsp", "dash"));
}
