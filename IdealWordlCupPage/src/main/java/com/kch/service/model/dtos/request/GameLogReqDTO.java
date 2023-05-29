package com.kch.service.model.dtos.request;

import lombok.*;

import java.time.LocalDateTime;

public class GameLogReqDTO {

    @Getter
    @Builder
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class CREATE{
        private Long gameId;
        private Long userId;
        private String gameLog;
    }

    //수정DTO 필요 없음
}
