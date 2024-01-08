package com.example.dropboxsfileservice.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    ERR_CODE_001("ERR.CODE.001", "File with this id %s not found"),
    ERR_CODE_002("ERR_CODE_002", "File with this userId %s not found");

    private final String code;
    private final String description;

    public String formatDescription(final Object... args) {
        return String.format(description, args);
    }
}
