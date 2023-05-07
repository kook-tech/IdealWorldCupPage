package com.kch.service.model.dtos.request;

import com.kch.persistence.entity.File;
import lombok.*;


public class GameElementReqDTO {

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class CREATE{
        private Long gameId;
        private File fileId;
        private String elementTitle;
        private int elementSelectCnt;
        private int elementWinCnt;
    }

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class UPDATE{
        private File fileId;
        private String elementTitle;
    }
}
