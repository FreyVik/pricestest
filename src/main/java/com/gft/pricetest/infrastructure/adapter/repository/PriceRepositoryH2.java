package com.gft.pricetest.infrastructure.adapter.repository;

import com.gft.pricetest.infrastructure.adapter.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PriceRepositoryH2 extends JpaRepository<PriceEntity, Integer> {

    @Query("SELECT p FROM PriceEntity p WHERE p.startDate <= ?1 AND p.endDate >= ?1 AND p.productId = ?2 AND p.brandId = ?3")
    List<PriceEntity> findByAppliedDateAndProductIdAndBrandId(LocalDateTime localDateTime, Integer productId, Integer brandId);

}
