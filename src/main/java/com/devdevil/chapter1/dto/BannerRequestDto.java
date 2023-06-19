package com.devdevil.chapter1.dto;

import com.devdevil.chapter1.entity.BannerEntity;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BannerRequestDto {

    private Long id;
    private String title;
    private String imageUrl;
    private Integer displayOrder;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public BannerEntity toEntity() {
        return BannerEntity.builder()
                .title(this.title)
                .displayOrder(this.displayOrder)
                .imageUrl(this.imageUrl)
                .startDate(this.startDate)
                .endDate(this.endDate)
                .build();
    }
}
