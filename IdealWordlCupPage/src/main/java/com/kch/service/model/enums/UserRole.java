package com.kch.service.model.enums;

import com.kch.infrastructure.error.NotFoundException;
import com.kch.infrastructure.model.ResponseStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum UserRole {
    USER("일반사용자"),
    ADMIN("관리자"),
    SUPER_ADMIN("최고관리자");
    String role;

    public static UserRole of(String role) {
        return Arrays.stream(UserRole.values())
                .filter(type -> type.toString().equalsIgnoreCase(role))
                .findAny().orElseThrow(() -> new NotFoundException(ResponseStatus.FAIL_NOT_FOUND));
    }
}
