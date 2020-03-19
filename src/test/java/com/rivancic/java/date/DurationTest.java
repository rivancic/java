package com.rivancic.java.date;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.junit.Test;

public class DurationTest {

  /**
   * Will throw runtime exception of type UnsupportedTemporalTypeException because d1 LocalDate
   * instance does not support seconds.
   *
   */
  @Test
  public void durationBetweenTest() {
    LocalDate d1 = LocalDate.now();
    LocalDateTime d2 = LocalDateTime.now();
    System.out.println(Duration.between(d1, d2));
  }
}
