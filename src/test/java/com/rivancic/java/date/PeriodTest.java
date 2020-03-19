package com.rivancic.java.date;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import java.time.Duration;
import java.time.Period;
import org.junit.Test;

public class PeriodTest {

  /**
   * The resulting period will have the specified days. The years and months units will be zero. No
   * matter which factory method was called first to create period instance. Next chained calls to
   * static methods will return new instance.
   */
  @Test
  public void periodTest() throws Exception {
    Period period = Period.of(2, 1, 0).ofYears(10).ofMonths(5).ofDays(2);
    System.out.println(period);
    assertEquals("P2D", period.toString());
  }

  /**
   * The same goes with the duration that holds time entities. Notice when using toString Duration
   * uses PT while Period has only P.
   */
  @Test
  public void durationTest() {
    Duration duration = Duration.ofMillis(100).ofNanos(10).ofSeconds(10).ofHours(10);
    assertThat(duration.toString(), is("PT10H"));
  }
}
