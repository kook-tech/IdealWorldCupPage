package com.kch.service.model.dtos.response;

import lombok.*;

import java.time.LocalDateTime;

public class BoardResDTO {

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class READ{
        private Long boardId;
        private Long UserId;
        private Long categoryId;
        private String boardTitle;
        private String boardContent;
        private LocalDateTime regDt;
        private LocalDateTime modDt;
    }

}
