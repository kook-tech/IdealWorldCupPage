package com.kch.service.model.dtos.response;

import lombok.*;

public class ReplyResDTO {

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class READ{
        private Long userId;
        private String content;
    }
}
