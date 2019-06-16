package com.example.test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class DataNotValidException extends RuntimeException {

    public DataNotValidException() {
        super();
    }

    public DataNotValidException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataNotValidException(String message) {
        super(message);
    }

    public DataNotValidException(Throwable cause) {
        super(cause);
    }
}
