package com.devdevil.chapter1.service;

import com.devdevil.chapter1.dto.BannerDto;
import com.devdevil.chapter1.entity.BannerEntity;
import com.devdevil.chapter1.repository.BannerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BannerService {

    private final BannerRepository bannerRepository;
    private final RedisTemplate<String, List<BannerDto>> redisTemplate;

    private static final String BANNER_KEY = "MAIN_BANNER";

    public List<BannerDto> getBanners() {
        // 캐시에서 배너를 찾는다.
        List<BannerDto> bannerDtos = redisTemplate.opsForValue().get(BANNER_KEY);

        // 없으면 - DB에서 배너 찾고, 캐시에 set한다.
        if (bannerDtos == null || bannerDtos.isEmpty()) {
            bannerDtos = getBannersFromDBAndSetCache();
        }
        return bannerDtos;
    }

    public List<BannerDto> getBannersFromDBAndSetCache() {
        // 현재시각이 노출기간 (startDate~endDate) 사이에 있는 배너 select, 정렬기준은 displayOrder 오름차순
        LocalDateTime now = LocalDateTime.now();
        List<BannerEntity> bannerEntities = bannerRepository.findByStartDateBeforeAndEndDateAfterOrderByDisplayOrder(now, now);

        // 엔티티를 DTO로 변환하고 redis에 저장.
        List<BannerDto> bannerDtos = bannerEntities.stream().map(e -> BannerDto.fromEntity(e)).collect(Collectors.toList());
        redisTemplate.opsForValue().set(BANNER_KEY, bannerDtos);
        return bannerDtos;
    }
}
