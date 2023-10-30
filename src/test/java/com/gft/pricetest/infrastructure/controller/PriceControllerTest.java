package com.gft.pricetest.infrastructure.controller;

import com.gft.pricetest.domain.usecase.PriceService;
import com.gft.pricetest.infrastructure.adapter.mapper.ResultPriceMapper;
import com.gft.pricetest.infrastructure.rest.controller.PriceController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.gft.pricetest.utils.Constants.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PriceControllerTest {

    @InjectMocks
    PriceController priceController;

    @Mock
    PriceService priceService;

    @Mock
    ResultPriceMapper resultPriceMapper;

    @Test
    @DisplayName("Verify injections")
    void shouldVerifyInjections() {
        when(priceService.getTariffPrice(any())).thenReturn(SIMPLE_RESULT_PRICE);
        when(resultPriceMapper.toDto(any())).thenReturn(RESULT_PRICE_DTO);

        priceController.getPrice("2020-06-14 18:30:01", 1, 1);

        verify(priceService, times(1)).getTariffPrice(any());
        verify(resultPriceMapper, times(1)).toDto(any());
    }
}