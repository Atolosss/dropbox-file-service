package com.example.dropboxsfileservice.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@Getter
public class FileError {
    private final String message;
    private final HttpStatus httpStatus;
    private final ZonedDateTime zonedDateTime;
}

