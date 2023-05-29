package com.kch.service.model.dtos.response;

import com.kch.service.model.enums.Category;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

public class BoardResDTO {

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class READ{
        private Long boardId;
        @NotNull
        private Long userId;
        private Category category;
        private String boardTitle;
        private String boardContent;
        private LocalDateTime regDt;
        private LocalDateTime modDt;
    }

}
