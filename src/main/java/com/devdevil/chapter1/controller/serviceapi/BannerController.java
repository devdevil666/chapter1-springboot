package com.devdevil.chapter1.controller.serviceapi;

import com.devdevil.chapter1.dto.BannerDto;
import com.devdevil.chapter1.service.BannerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/service/banner")
@RequiredArgsConstructor
public class BannerController {
    private final BannerService bannerService;

    // 현재 노출기간 중인 배너 리스트 get
    @GetMapping("")
    public ResponseEntity<Object> getBanners() throws Exception {
        List<BannerDto> banners = bannerService.getBanners();
        return ResponseEntity.ok(banners);
    }
}
