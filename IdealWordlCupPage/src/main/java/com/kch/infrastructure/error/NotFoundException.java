package com.kch.infrastructure.error;

import com.kch.infrastructure.model.ResponseStatus;

public class NotFoundException extends BusinessLogicException{
    public NotFoundException(ResponseStatus responseStatus) {
        super(responseStatus);
    }

    public NotFoundException(String message) {
        super(message);
    }
}
