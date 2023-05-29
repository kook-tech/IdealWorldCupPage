package com.kch.service.model.dtos.request;

import com.kch.service.model.enums.Category;
import jakarta.validation.constraints.NotNull;
import lombok.*;

public class BoardReqDTO {

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class CREATE{
        @NotNull
        private Long userId;
        private Category category;
        private String boardTitle;
        private String boardContent;

    }

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class UPDATE{
        private String boardTitle;
        private String boardContent;
    }
}
