package com.kch.infrastructure.error;

import com.kch.infrastructure.model.ResponseStatus;

public class DuplicatedException extends BusinessLogicException{
    public DuplicatedException(ResponseStatus responseStatus) {
        super(responseStatus);
    }

    public DuplicatedException(String message) {
        super(message);
    }
}
