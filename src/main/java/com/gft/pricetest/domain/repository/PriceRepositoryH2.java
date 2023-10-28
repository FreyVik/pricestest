package com.gft.pricetest.domain.repository;

import com.gft.pricetest.domain.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PriceRepositoryH2 extends JpaRepository<Price, Integer> {

    @Query("SELECT p FROM Price p WHERE p.startDate <= ?1 AND p.endDate >= ?1 AND p.productId = ?2 AND p.brandId = ?3")
    List<Price> findByAppliedDateAndProductIdAndBrandId(LocalDateTime localDateTime, Integer productId, Integer brandId);

}
