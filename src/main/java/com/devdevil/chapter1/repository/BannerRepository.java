package com.devdevil.chapter1.repository;

import com.devdevil.chapter1.entity.BannerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BannerRepository extends JpaRepository<BannerEntity, Long> {
    List<BannerEntity> findByStartDateBeforeAndEndDateAfterOrderByDisplayOrder(LocalDateTime now, LocalDateTime now1);
}
