package com.rivancic.java.date;

import static org.junit.Assert.assertEquals;
import java.time.Period;
import org.junit.Test;

public class PeriodTest {

  /**
   * The resulting period will have the specified days. The years and months units will be zero. No
   * metter which factory method was called first to create period instance. Next chained calls to
   * static methods will return new instance.
   * 
   * @throws Exception
   */
  @Test
  public void periodTest() throws Exception {
    Period period = Period.of(2, 1, 0).ofYears(10).ofMonths(5).ofDays(2);
    System.out.println(period);
    assertEquals("P2D", period.toString());
  }
}
