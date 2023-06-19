package com.devdevil.chapter1.entity;

import com.devdevil.chapter1.dto.BannerRequestDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "banner")
public class BannerEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String imageUrl;
    private Integer displayOrder;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public void update (BannerRequestDto bannerRequestDto) {
        this.title = bannerRequestDto.getTitle();
        this.displayOrder = bannerRequestDto.getDisplayOrder();
        this.imageUrl = bannerRequestDto.getImageUrl();
        this.startDate = bannerRequestDto.getStartDate();
        this.endDate = bannerRequestDto.getEndDate();
    }

}
