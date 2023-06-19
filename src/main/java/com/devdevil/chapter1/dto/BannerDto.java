package com.devdevil.chapter1.dto;

import com.devdevil.chapter1.entity.BannerEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BannerDto {

    private Long id;
    private String title;
    private String imageUrl;
    private Integer displayOrder;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private LocalDateTime insertDate;

    public static BannerDto fromEntity (BannerEntity bannerEntity) {
        return new BannerDtoBuilder()
                .id(bannerEntity.getId())
                .title(bannerEntity.getTitle())
                .imageUrl(bannerEntity.getImageUrl())
                .displayOrder(bannerEntity.getDisplayOrder())
                .startDate(bannerEntity.getStartDate())
                .endDate(bannerEntity.getEndDate())
                .insertDate(bannerEntity.getInsertDate())
                .build();
    }

}
