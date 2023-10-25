package com.gft.pricetest.utils;

import java.time.LocalDateTime;

public class DateTimeFormatter {

    public static LocalDateTime parseToLocalDateTime(String string) {
        java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(string, formatter);
    }
}
