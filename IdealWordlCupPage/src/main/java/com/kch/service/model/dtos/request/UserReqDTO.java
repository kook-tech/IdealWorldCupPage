package com.kch.service.model.dtos.request;

import com.kch.service.model.enums.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.*;

import java.time.LocalDateTime;

public class UserReqDTO {

    @Builder
    @Getter
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class CREATE{
        @NotBlank(message = "아이디를 입력해주세요")
        private String loginId;
        @NotBlank(message = "비밀번호를 입력해주세요")
        private String password;
        @NotBlank(message = "이름을 입력해주세요")
        private String name;
        @Past(message = "생년월일은 과거이어야 합니다")
        private LocalDateTime birth;
        @NotBlank(message = "이메일을 입력해주세요")
        private String email;

        private UserRole role;
    }

    @Builder
    @Getter
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class UPDATE{

        @NotBlank(message = "비밀번호를 입력해주세요")
        private String password;
        @NotBlank(message = "이름을 입력해주세요")
        private String name;
        @NotBlank(message = "이메일을 입력해주세요")
        private String email;

    }


}
