package com.gft.pricetest.domain.port;

import com.gft.pricetest.domain.model.Price;
import com.gft.pricetest.infrastructure.adapter.entity.PriceEntity;

import java.time.LocalDateTime;
import java.util.List;

public interface PricePersistencePort {

    List<Price> findByAppliedDateAndProductIdAndBrandId(LocalDateTime localDateTime, Integer productId, Integer brandId);

}
