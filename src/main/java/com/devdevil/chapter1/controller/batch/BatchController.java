package com.devdevil.chapter1.controller.batch;

import com.devdevil.chapter1.service.BannerService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BatchController {

    private final BannerService bannerService;

    // 매 시 정각마다 배너 캐시 갱신
    @Scheduled(cron = "0 * * * * *") // 초 분 시 일 월 요일
    public void setBannersToCache() {
        try {
            bannerService.getBannersFromDBAndSetCache();
        } catch (Exception e) {
            throw new RuntimeException("[ERROR] 배너 갱신 배치 동작 오류 : ", e);
        }
    }
}
