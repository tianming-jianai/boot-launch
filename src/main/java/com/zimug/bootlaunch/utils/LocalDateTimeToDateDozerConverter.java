package com.zimug.bootlaunch.utils;

import org.dozer.DozerConverter;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author You
 * @version 0.1.0
 * @Description
 * @create 2020-05-03 16:43
 * @since 0.1.0
 **/
public class LocalDateTimeToDateDozerConverter extends DozerConverter<LocalDateTime, Date> {

    public LocalDateTimeToDateDozerConverter() {
        super(LocalDateTime.class, Date.class);
    }

    @Override
    public LocalDateTime convertFrom(Date source, LocalDateTime destination) {
        LocalDateTime dateTime = LocalDateTime.ofInstant(source.toInstant(), ZoneId.systemDefault());
        return dateTime;
    }

    @Override
    public Date convertTo(LocalDateTime source, Date destination) {
        Date convertToDate = Date.from(source.atZone(ZoneId.systemDefault()).toInstant());
        return convertToDate;
    }

}
