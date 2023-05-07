package com.kch.service.model.dtos.response;

import com.kch.persistence.entity.File;
import lombok.*;

import java.time.LocalDateTime;

public class GameResDTO {

    @Builder
    @Getter
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class READ{
        private Long gameId;
        private Long userId;
        private File fileId;
        private String gameTitle;
        private String gameDescription;
        private LocalDateTime regDt;
        private LocalDateTime modDt;
    }
}
