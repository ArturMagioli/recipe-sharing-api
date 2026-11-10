package com.magioli.recipesharing.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PathConfig {

    @Bean(name = "publicPaths")
    public List<String> publicPaths() {
        return List.of(
                "/auth/login",
                "/auth/register",
                "/h2-console/**"
        );
    }

    @Bean(name = "authenticatedPaths")
    public List<String> authenticatedPaths() {
        return List.of(
                "/users/**"
        );
    }
}
