package com.emosphere.emosphere.utils;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.YearMonth;
import java.time.ZoneId;
import java.util.Date;

public class DateUtil {
  public   Date getDayStart(Date date) {
        // 将java.util.Date转换为LocalDateTime
        LocalDateTime localDateTime = date2Local(date);

        // 获取当天的开始时间
        LocalDateTime startOfDay = localDateTime.with(LocalTime.MIN);
        return local2Date(startOfDay);

    }

    public  Date getDayEnd(Date date) {
        // 将java.util.Date转换为LocalDateTime
        LocalDateTime localDateTime = date2Local(date);
        // 获取当天的结束时间
        LocalDateTime endOfDay = localDateTime.with(LocalTime.MAX);
        return local2Date(endOfDay);
    }

    public  Date getMonthStart(Date date) {
        LocalDateTime localDateTime = date2Local(date);
        // 获取所在月的第一天
        LocalDateTime firstDayOfMonth = localDateTime.withDayOfMonth(1).withHour(0).withMinute(0).withSecond(0);
        return local2Date(firstDayOfMonth);
    }

    public  Date getMonthEnd(Date date) {
        LocalDateTime localDateTime = date2Local(date);
        YearMonth yearMonth = YearMonth.from(localDateTime);
        int lastDay = yearMonth.lengthOfMonth();
        LocalDateTime lastDayOfMonth = localDateTime.withDayOfMonth(lastDay).withHour(23).withMinute(59).withSecond(59);
        return local2Date(lastDayOfMonth);
    }

    Date local2Date(LocalDateTime dateTime) {
        return Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    LocalDateTime date2Local(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}
