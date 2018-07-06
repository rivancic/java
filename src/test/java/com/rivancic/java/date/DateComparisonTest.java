package com.rivancic.java.date;

import static org.junit.Assert.assertEquals;
import java.time.LocalDate;
import org.junit.Test;

public class DateComparisonTest {

  /**
   * Comparison operators are checking only reference equality. So the result will be:<br>
   * false:false:false
   * 
   * @throws Exception
   */
  @Test
  public void dateComparison() throws Exception {
    LocalDate d1 = LocalDate.parse("1999-09-09");
    LocalDate d2 = LocalDate.parse("1999-09-09");
    LocalDate d3 = LocalDate.of(1999, 9, 9);
    LocalDate d4 = LocalDate.of(1999, 9, 9);
    System.out.println((d1 == d2) + ":" + (d2 == d3) + ":" + (d3 == d4));
    assertEquals(false, d1 == d2);
    assertEquals(false, d2 == d3);
    assertEquals(false, d3 == d4);
  }

  @Test
  public void checkEquality() throws Exception {
    LocalDate date1 = LocalDate.parse("1980-03-16");
    LocalDate date2 = LocalDate.parse("1980-03-16");
    System.out.println(date1.equals(date2) + " : " + date1.isEqual(date2));
    assertEquals(true, date1.equals(date2));
    assertEquals(true, date1.isEqual(date2));
  }
}
