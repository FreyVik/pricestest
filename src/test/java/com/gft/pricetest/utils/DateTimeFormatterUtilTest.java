package com.gft.pricetest.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class DateTimeFormatterUtilTest {

    private final LocalDateTime localDateTimeDateTime = LocalDateTime.of(
            LocalDate.of(2020, 6, 14),
            LocalTime.of(18, 30, 1));

    private final String stringDateTime = "2020-06-14 18:30:01";

    @Test
    @DisplayName("Parse String to LocalDateTime")
    public void shouldParteStringToLocalDateTime() {
        LocalDateTime localDateTimeResult = DateTimeFormatterUtil.parseToLocalDateTime(stringDateTime);

        assertEquals(localDateTimeDateTime, localDateTimeResult);
    }

    @Test
    @DisplayName("Parse LocalDateTime to String")
    public void shouldParteLocalDateTimeToString() {
        String stringResult = DateTimeFormatterUtil.parseToString(localDateTimeDateTime);

        assertEquals(stringDateTime, stringResult);
    }
}