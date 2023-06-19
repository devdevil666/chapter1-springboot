package com.devdevil.chapter1.service;

import com.devdevil.chapter1.dto.BannerDto;
import com.devdevil.chapter1.dto.BannerRequestDto;
import com.devdevil.chapter1.entity.BannerEntity;
import com.devdevil.chapter1.repository.BannerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminBannerService {

    private final BannerRepository bannerRepository;

    public BannerDto saveBanner(BannerRequestDto bannerRequestDto) {
        BannerEntity bannerEntity = new BannerEntity();
        // 추가
        if (bannerRequestDto.getId() == null) {
            bannerEntity = bannerRequestDto.toEntity();
            bannerRepository.save(bannerEntity);
        }
        // 수정
        else {
            Optional<BannerEntity> bannerEntityOptional = bannerRepository.findById(bannerRequestDto.getId());
            if (bannerEntityOptional.isPresent()) {
                bannerEntity = bannerEntityOptional.get();
                bannerEntity.update(bannerRequestDto);
            }
            else {
                // 예외처리
            }
        }
        return BannerDto.fromEntity(bannerEntity);
    }

}
