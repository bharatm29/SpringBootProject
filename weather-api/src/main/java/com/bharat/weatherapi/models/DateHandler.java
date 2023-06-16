package com.bharat.weatherapi.models;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateHandler{
    public static String getFormatDate(String wrapperDate){
        Instant utcParsedDate = Instant.parse(wrapperDate);

        ZoneId zoneId = ZoneId.of("Asia/Kolkata");
        ZonedDateTime correctZonedDate = utcParsedDate.atZone(zoneId);

        String date = correctZonedDate.format(DateTimeFormatter.ofPattern("E, dd MMMM yyyy, HH:mm z"));

        return date;
    }
}
