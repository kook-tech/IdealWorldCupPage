package com.kch.persistence;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@MappedSuperclass
@EqualsAndHashCode(of = "id", callSuper = false)
@Getter
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @CreatedDate
    private LocalDateTime regDt;

    @LastModifiedDate
    private LocalDateTime modDt;

    @PrePersist
    public void onPrePersist() {
        this.regDt = LocalDateTime.now();
        this.modDt = LocalDateTime.now();
    }

    @PreUpdate
    public void onPreUpdate() {
        this.modDt = LocalDateTime.now();
    }
}