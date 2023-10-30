package com.gft.pricetest.infrastructure.adapter;

import com.gft.pricetest.domain.model.Price;
import com.gft.pricetest.domain.port.PricePersistencePort;
import com.gft.pricetest.infrastructure.adapter.entity.PriceEntity;
import com.gft.pricetest.infrastructure.adapter.mapper.PriceMapper;
import com.gft.pricetest.infrastructure.adapter.repository.PriceRepositoryH2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class PriceAdapter implements PricePersistencePort {

    PriceRepositoryH2 priceRepositoryH2;

    PriceMapper priceMapper;

    public PriceAdapter (PriceRepositoryH2 priceRepositoryH2, PriceMapper priceMapper) {
        this.priceRepositoryH2 = priceRepositoryH2;
        this.priceMapper = priceMapper;
    }

    @Override
    public List<Price> findByAppliedDateAndProductIdAndBrandId(LocalDateTime localDateTime, Integer productId, Integer brandId) {

        List<PriceEntity> priceList = priceRepositoryH2.findByAppliedDateAndProductIdAndBrandId(localDateTime, productId, brandId);

        return priceMapper.toDomain(priceList);
    }
}
