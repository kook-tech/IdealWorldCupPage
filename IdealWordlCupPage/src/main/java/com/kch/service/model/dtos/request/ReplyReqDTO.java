package com.kch.service.model.dtos.request;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Null;
import lombok.*;

public class ReplyReqDTO {

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class CREATE{
        private Long userId;
        private Long boardId;
        private Long gameId;
        private String content;
    }

    @Getter
    @Builder
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class UPDATE{
        private String content;
    }
}
