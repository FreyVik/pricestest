package com.gft.pricetest.application.service;

import com.gft.pricetest.application.model.ResultPrice;
import com.gft.pricetest.domain.port.PricePersistencePort;
import com.gft.pricetest.infrastructure.adapter.exception.NotFoundTariffPriceException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static com.gft.pricetest.utils.Constants.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DefaultPriceServiceTest {

    @InjectMocks
    DefaultPriceService defaultPriceService;

    @Mock
    PricePersistencePort pricePersistencePort;

    private ResultPrice expectedResultPrice = ResultPrice.builder()
            .productId(SECOND_TARIFF_PRICE.getProductId())
            .brandId(SECOND_TARIFF_PRICE.getBrandId())
            .tariffId(2)
            .appliedDate(SIMPLE_LOCAL_DATE_TIME)
            .price(SECOND_TARIFF_PRICE.getPrice())
            .build();

    @Test
    @DisplayName("Get simple tariff price")
    public void shouldReturnTariffPrice() {
        when(pricePersistencePort.findByAppliedDateAndProductIdAndBrandId(any(), any(), any())).thenReturn(SIMPLE_PRICE_LIST_ENTITY);

        ResultPrice result = defaultPriceService.getTariffPrice(SIMPLE_APP_TARIFF_REQUEST);

        assertEquals(expectedResultPrice, result);
    }

    @Test
    @DisplayName("Get simple tariff price if repository returns list of one element")
    public void shouldReturnTariffPriceWithOneElement() {
        when(pricePersistencePort.findByAppliedDateAndProductIdAndBrandId(any(), any(), any())).thenReturn(SIMPLE_PRICE_LIST_OF_1);

        ResultPrice result = defaultPriceService.getTariffPrice(SIMPLE_APP_TARIFF_REQUEST);

        assertEquals(expectedResultPrice, result);
    }

    @Test
    @DisplayName("Throw NotFoundTariffPriceException if repository return empty list")
    public void shouldThrowNotFoundTariffPriceException() {
        when(pricePersistencePort.findByAppliedDateAndProductIdAndBrandId(any(), any(), any())).thenReturn(Collections.emptyList());

        assertThrows(NotFoundTariffPriceException.class, () ->
                defaultPriceService.getTariffPrice(SIMPLE_APP_TARIFF_REQUEST));
    }
}