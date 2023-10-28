package com.gft.pricetest.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatterUtil {

    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);

    public static LocalDateTime parseToLocalDateTime(String string) {
        return LocalDateTime.parse(string, formatter);
    }

    public static String parseToString(LocalDateTime localDateTime) {
        return localDateTime.format(formatter);
    }
}
