package com.kch.service.model.dtos.response;

import com.kch.service.model.enums.UserRole;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

public class UserResDTO {


    @Builder
    @Getter
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class READ {
        private String loginId;
        private String password;
        private String name;
        private LocalDateTime birth;
        private String email;
        private UserRole role = UserRole.USER;
        private LocalDateTime regDt;
        private LocalDateTime modDt;
    }
}
