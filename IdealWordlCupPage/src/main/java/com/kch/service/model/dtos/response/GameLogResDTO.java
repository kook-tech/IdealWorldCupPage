package com.kch.service.model.dtos.response;

import lombok.*;

import java.time.LocalDateTime;

public class GameLogResDTO {


    @Getter
    @Builder
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class READ{
        private Long gameId;
        private Long userId;
        private String gameLog;
        private LocalDateTime regDt;
    }
}
