package com.devdevil.chapter1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@MappedSuperclass
public abstract class BaseEntity {
    @Column(updatable = false)
    private LocalDateTime insertDate;
    private LocalDateTime updateDate;

    @PrePersist
    public void before() {
        LocalDateTime now = LocalDateTime.now();
        this.insertDate = now;
        this.updateDate = now;
    }

    @PreUpdate
    public void always() {
        this.updateDate = LocalDateTime.now();
    }
}