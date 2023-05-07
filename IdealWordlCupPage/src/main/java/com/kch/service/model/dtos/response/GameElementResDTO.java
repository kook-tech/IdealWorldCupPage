package com.kch.service.model.dtos.response;

import com.kch.persistence.entity.File;
import lombok.*;

import java.time.LocalDateTime;

public class GameElementResDTO {

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class READ{
        private Long gameId;
        private File fileId;
        private String elementTitle;
        private int elementSelectCnt;
        private int elementWinCnt;
        private LocalDateTime regDt;
        private LocalDateTime modDt;
    }
}
