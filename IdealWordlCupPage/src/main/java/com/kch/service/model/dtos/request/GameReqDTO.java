package com.kch.service.model.dtos.request;

import com.kch.persistence.entity.File;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

public class GameReqDTO {

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class CREATE{
        @NotNull(message = "아이디가 비었습니다")
        private Long userId;
        @NotNull(message = "이미지 파일을 첨부해주세요")
        private Long fileId;
        @NotBlank(message = "게임 이름을 입력하세요")
        private String gameTitle;
        //description null 허용
        private String gameDescription;
    }

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class UPDATE{
        private Long fileId;
        private String gameTitle;
        private String gameDescription;
    }
}
