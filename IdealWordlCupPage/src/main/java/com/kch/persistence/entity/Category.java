package com.kch.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="TBL_CATEGORIES")
@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="category_id")
    private Long categoryId;

    @Column(name="category_name")
    private String categoryName;

    @Builder
    private Category(Long categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }
}
