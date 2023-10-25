package com.gft.pricetest.framework.controller.price;

import com.gft.pricetest.application.model.price.AppResultPrice;
import com.gft.pricetest.application.service.price.PriceService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.gft.pricetest.utils.Constants.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PriceControllerTest {

    @InjectMocks
    PriceController priceController;

    @Mock
    PriceService priceService;

//    @Test
//    @DisplayName("Verify injections")
//    void shouldVerifyInjections() {
//        when(priceService.getTariffPrice(any())).thenReturn(SIMPLE_RESULT_PRICE);
//
//        priceController.getPrice(OFFSET_DATE_TIME, 1, 1);
//
//        verify(priceService, times(1)).getTariffPrice(any());
//    }
}