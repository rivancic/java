package com.rivancic.java;

import java.time.LocalDate;
import org.junit.Test;


public class LocalDateTest {

  /**
   * The EPOCH_DAY is a simple incrementing count of days where day 0 is 1970-01-01.
   * Negative numbers represent earlier days.
   *
   * LocalDate toString is being written as ISO-8601 format {@code uuuu-MM-dd}.
   *
   * The result will be 1970-01-02
   */
  @Test
  public void testEpochDay() {
    LocalDate date = LocalDate.ofEpochDay(1);
    org.junit.Assert.assertEquals(LocalDate.of(1970,1,2), date);
    System.out.println(date);
  }
}
