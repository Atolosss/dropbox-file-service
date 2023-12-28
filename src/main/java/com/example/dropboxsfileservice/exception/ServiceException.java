package com.example.dropboxsfileservice.exception;

import com.example.dropboxsfileservice.constant.ErrorCode;

import java.io.Serial;

public class ServiceException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 123456789L;

    public ServiceException(final ErrorCode errorCode, final Object... args) {
        super(errorCode.formatDescription(args));
    }

    public ServiceException(final ErrorCode errorCode) {
        super(errorCode.getDescription());
    }
}
