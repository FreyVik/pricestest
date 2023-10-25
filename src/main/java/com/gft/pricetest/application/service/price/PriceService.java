package com.gft.pricetest.application.service.price;

import com.gft.pricetest.application.model.price.AppResultPrice;
import com.gft.pricetest.application.model.price.AppTariffRequest;
import org.springframework.stereotype.Service;

@Service
public interface PriceService {

    AppResultPrice getTariffPrice(AppTariffRequest appTariffRequest);

}
