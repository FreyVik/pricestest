package com.gft.pricetest.domain.repository.price;

import com.gft.pricetest.domain.model.price.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<Price, Integer> {

    @Query("SELECT p FROM Price p WHERE p.startDate <= ?1 AND p.endDate >= ?1 AND p.productId = ?2")
    List<Price> findByAppliedDateAndProductId(LocalDateTime localDateTime, Integer productId);

    @Query("SELECT p FROM Price p WHERE p.productId = ?1")
    List<Price> customQuery(Integer productId);

}
