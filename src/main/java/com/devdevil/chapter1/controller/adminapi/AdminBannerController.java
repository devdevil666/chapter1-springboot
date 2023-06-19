package com.devdevil.chapter1.controller.adminapi;

import com.devdevil.chapter1.dto.BannerDto;
import com.devdevil.chapter1.dto.BannerRequestDto;
import com.devdevil.chapter1.service.AdminBannerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/banner")
@RequiredArgsConstructor
public class AdminBannerController {

    private final AdminBannerService adminBannerService;

    // BannerRequestDto 형태로 입력을 받아, 배너를 DB에 insert or update
    @PostMapping("")
    @Transactional
    public ResponseEntity<Object> saveBanner(@RequestBody BannerRequestDto bannerRequestDto) {
        BannerDto bannerDto = adminBannerService.saveBanner(bannerRequestDto);
        return ResponseEntity.ok(bannerDto);
    }
}
