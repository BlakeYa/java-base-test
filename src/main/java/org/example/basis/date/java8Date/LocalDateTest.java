package org.example.basis.date.java8Date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTest {

    public static void main(String[] args) {
        //LocalDate、LocalTime、LocalDateTime 都是  严格按照ISO 8601格式打印
        System.out.println(LocalDate.now()); //2020-08-26
        System.out.println(LocalTime.now()); //14:37:13.136779300
        System.out.println(LocalDateTime.now());//2020-08-26T14:38:01.606424


        LocalDateTime now = LocalDateTime.now();
        LocalDate localDate = now.toLocalDate();
        LocalTime localTime = now.toLocalTime();

        System.out.println(LocalDateTime.of(localDate, localTime));


        // 自定义格式化:
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        System.out.println(dtf.format(LocalDateTime.now()));

        // 用自定义格式解析:
        LocalDateTime dt2 = LocalDateTime.parse("2019/11/30 15:16:17", dtf);
        System.out.println(dt2);

        LocalDateTime dt = LocalDateTime.of(2019, 10, 26, 20, 30, 59);
        System.out.println(dt);

        // 加5天减3小时:
        LocalDateTime dt1 = dt.plusDays(5).minusHours(3);
        System.out.println(dt1); // 2019-10-31T17:30:59
        // 减1月:
        LocalDateTime dt3 = dt1.minusMonths(1);
        System.out.println(dt3); // 2019-09-30T17:30:59


    }
}
