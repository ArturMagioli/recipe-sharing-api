package com.magioli.recipesharing.exception;

import com.magioli.recipesharing.exception.dto.ExceptionResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalHandleException {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponseDto> handleException(Exception e) {

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ExceptionResponseDto(HttpStatus.INTERNAL_SERVER_ERROR, List.of(e.getMessage())));
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ExceptionResponseDto>  handleBadCredentialsException(BadCredentialsException e) {
        ExceptionResponseDto exceptionResponse = new ExceptionResponseDto(HttpStatus.BAD_REQUEST, List.of(e.getMessage()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ExceptionResponseDto>  handleUsernameNotFoundException(UsernameNotFoundException e) {
        ExceptionResponseDto exceptionResponse = new ExceptionResponseDto(HttpStatus.BAD_REQUEST, List.of(e.getMessage()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponseDto> handleArgumentNotValidException(MethodArgumentNotValidException e) {
        List errorMessages = e.getBindingResult().getAllErrors().stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.toList());
        ExceptionResponseDto exceptionResponse = new ExceptionResponseDto(e.getStatusCode(), errorMessages);
        return ResponseEntity.internalServerError().body(exceptionResponse);
    }
}
