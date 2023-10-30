package com.gft.pricetest.application.service;

import com.gft.pricetest.application.model.ResultPrice;
import com.gft.pricetest.application.model.AppTariffRequest;
import com.gft.pricetest.domain.model.Price;
import com.gft.pricetest.domain.port.PricePersistencePort;
import com.gft.pricetest.infrastructure.adapter.entity.PriceEntity;
import com.gft.pricetest.domain.usecase.PriceService;
import com.gft.pricetest.infrastructure.adapter.repository.PriceRepositoryH2;
import com.gft.pricetest.infrastructure.adapter.exception.NotFoundTariffPriceException;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class DefaultPriceService implements PriceService {

    PricePersistencePort pricePersistencePort;

    public DefaultPriceService(PricePersistencePort pricePersistencePort) {
        this.pricePersistencePort = pricePersistencePort;
    }

    @Override
    public ResultPrice getTariffPrice(AppTariffRequest appTariffRequest) {

        List<Price> priceList = pricePersistencePort.findByAppliedDateAndProductIdAndBrandId(
                appTariffRequest.getAppliedDate(),
                appTariffRequest.getProductId(),
                appTariffRequest.getBrandId());

        if (!priceList.isEmpty()) {
            Price selectedPriceEntity = priceList.stream()
                    .max(Comparator.comparingInt(Price::getPriority)).get();

            return ResultPrice.builder()
                    .productId(selectedPriceEntity.getProductId())
                    .brandId(selectedPriceEntity.getBrandId())
                    .tariffId(selectedPriceEntity.getPriceId())
                    .appliedDate(appTariffRequest.getAppliedDate())
                    .price(selectedPriceEntity.getPrice())
                    .build();

        } else {
            throw new NotFoundTariffPriceException(appTariffRequest);
        }
    }
}
