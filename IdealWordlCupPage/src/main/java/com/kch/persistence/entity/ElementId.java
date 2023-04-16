package com.kch.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ElementId implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "game_id")
    private Long gameId;

    @Column(name = "element_id")
    private Long elementId;
}