package com.kch.persistence;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EqualsAndHashCode(of = "id", callSuper = false)
@EntityListeners(AuditingEntityListener.class)
@Getter
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @CreatedDate
    @Column(name="reg_dt")
    private LocalDateTime regDt;

    @LastModifiedDate
    @Column(name="mod_dt")
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