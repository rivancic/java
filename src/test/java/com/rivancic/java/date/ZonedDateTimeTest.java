package com.rivancic.java.date;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import org.junit.Test;

public class ZonedDateTimeTest {

  @Test
  public void test() {
    LocalDate date = LocalDate.of(2019, 1, 1);
    LocalTime time = LocalTime.of(0, 0);
    ZoneId india = ZoneId.of("Asia/Kolkata");
    ZonedDateTime zIndia = ZonedDateTime.of(date, time, india);

    ZoneId us = ZoneId.of("America/Los_Angeles");

    // Zone is switched, the local day stays the same
    ZonedDateTime zUS = zIndia.withZoneSameLocal(us);

    // Zone is switched but also Instance is recalculated
    ZonedDateTime zUS1 = zIndia.withZoneSameInstant(us);

    System.out.println(Duration.between(zIndia, zUS));
    System.out.println(Duration.between(zIndia, zUS1));
  }
}
