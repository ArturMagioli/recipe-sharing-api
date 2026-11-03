package com.magioli.recipesharing.exception.dto;

import org.springframework.http.HttpStatusCode;

import java.util.List;

public record ExceptionResponseDto(HttpStatusCode status, List<String> messages) {
}
