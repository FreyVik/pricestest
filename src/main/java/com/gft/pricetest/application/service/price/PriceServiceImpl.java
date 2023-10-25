package com.gft.pricetest.application.service.price;

import com.gft.pricetest.application.model.price.AppResultPrice;
import com.gft.pricetest.application.model.price.AppTariffRequest;
import com.gft.pricetest.domain.model.price.Price;
import com.gft.pricetest.domain.repository.price.PriceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Service
public class PriceServiceImpl implements PriceService {

    PriceRepository priceRepository;

    public PriceServiceImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public AppResultPrice getTariffPrice(AppTariffRequest appTariffRequest) {

        List<Price> prices = priceRepository.findByAppliedDateAndProductId(appTariffRequest.getAppliedDate(), appTariffRequest.getProductId());

        if (!prices.isEmpty()) {
            Price selectedPrice = prices.stream()
                    .max(Comparator.comparingInt(Price::getPriority)).get();

            return AppResultPrice.builder()
                    .productId(selectedPrice.getProductId())
                    .brandId(selectedPrice.getBrandId())
                    .appliedDate(appTariffRequest.getAppliedDate())
                    .price(selectedPrice.getPrice())
                    .build();

        } else {
            return null;
        }


    }
}
