package com.gft.pricetest.infrastructure.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Nested
    class basicIntegration {
        @Test
        @Order(1)
        @DisplayName("Test 1")
        public void shouldGetPrice35_5At20200614_1000() throws Exception {
            mockMvc.perform(MockMvcRequestBuilders.get("/price?appliedDate=2020-06-14 10:00:00&productId=35455&brandId=1")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.price").value(35.5));
        }

        @Test
        @Order(2)
        @DisplayName("Test 2")
        public void shouldGetPrice25_45At20200614_1600() throws Exception {
            mockMvc.perform(MockMvcRequestBuilders.get("/price?appliedDate=2020-06-14 16:00:00&productId=35455&brandId=1")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.price").value(25.45));
        }

        @Test
        @Order(3)
        @DisplayName("Test 3")
        public void shouldGetPrice35_5At20200614_2100() throws Exception {
            mockMvc.perform(MockMvcRequestBuilders.get("/price?appliedDate=2020-06-14 21:00:00&productId=35455&brandId=1")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.price").value(35.5));
        }

        @Test
        @Order(4)
        @DisplayName("Test 4")
        public void shouldGetPrice30_5At20200615_1000() throws Exception {
            mockMvc.perform(MockMvcRequestBuilders.get("/price?appliedDate=2020-06-15 10:00:00&productId=35455&brandId=1")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.price").value(30.5));
        }

        @Test
        @Order(5)
        @DisplayName("Test 5")
        public void shouldGetPrice38_95At20200616_2100() throws Exception {
            mockMvc.perform(MockMvcRequestBuilders.get("/price?appliedDate=2020-06-16 21:00:00&productId=35455&brandId=1")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.price").value(38.95));
        }
    }

    @Nested
    class exceptionIntegration {
        @Test
        @DisplayName("Test - Bad Request parameter not found")
        public void shouldGetParameterNotFoundError() throws Exception {
            mockMvc.perform(MockMvcRequestBuilders.get("/price?appliedDate=2020-06-16 21:00:00&productId=35455&brandId=")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().is(HttpStatus.BAD_REQUEST.value()))
                    .andExpect(jsonPath("$.description").value("Parameter [brandId] not found"));
        }

        @Test
        @DisplayName("Test - Bad Request parameter format")
        public void shouldGetParameterFormatError() throws Exception {
            mockMvc.perform(MockMvcRequestBuilders.get("/price?appliedDate=2020-06-16 21:00:00&productId=string&brandId=1")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().is(HttpStatus.BAD_REQUEST.value()))
                    .andExpect(jsonPath("$.description").value("Parameter [productId] is not java.lang.Integer"));
        }

        @Test
        @DisplayName("Test - Bad Request date format")
        public void shouldGetParameterDateFormatError() throws Exception {
            mockMvc.perform(MockMvcRequestBuilders.get("/price?appliedDate=16-06-2020 21:00:00&productId=35455&brandId=1")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().is(HttpStatus.BAD_REQUEST.value()))
                    .andExpect(jsonPath("$.description").value("'16-06-2020 21:00:00' doesn't comply with date format yyyy-MM-dd HH:mm:ss"));
        }
    }
}


