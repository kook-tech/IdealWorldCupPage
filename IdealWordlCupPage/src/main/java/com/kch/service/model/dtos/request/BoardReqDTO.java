package com.kch.service.model.dtos.request;

import com.kch.persistence.entity.Category;
import com.kch.persistence.entity.File;
import com.kch.persistence.entity.User;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

public class BoardReqDTO {

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class CREATE{
        private Long UserId;
        private Long categoryId;
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
