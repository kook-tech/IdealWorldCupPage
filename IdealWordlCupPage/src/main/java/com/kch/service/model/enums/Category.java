package com.kch.service.model.enums;

import com.kch.infrastructure.error.NotFoundException;
import com.kch.infrastructure.model.ResponseStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
@Getter
@AllArgsConstructor
public enum Category {

    NOTICE("공지사항"),
    FREEBOARD("자유게시판");
    String category;

    public static Category of(Long categoryNum) {
        return Arrays.stream(Category.values())
                .filter(category -> category.ordinal() == categoryNum.intValue())
                .findFirst()
                .orElseThrow(() -> new NotFoundException(ResponseStatus.FAIL_NOT_FOUND));
    }
}
