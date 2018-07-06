package com.rivancic.java.date;

import static org.junit.Assert.assertEquals;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import org.junit.Test;

public class DateCalculationTest {

  /**
   * When using addition or subtraction on dates the same rules as in arithmetics apply. When
   * subtracting negative value it is actually adding it.
   * 
   * @throws Exception
   */
  @Test
  public void dateSubstraction() throws Exception {
    LocalDate date = LocalDate.parse("1980-03-16");
    LocalDate minusYears = date.minusYears(-5);
    assertEquals("1985-03-16", minusYears.toString());
  }

  /**
   * Because the date types are immutable, method minusDays will not change anything on date
   * instance. It will still hold the date 2018-06-06.
   * 
   * @throws Exception
   */
  @Test
  public void substractionOfDates() throws Exception {
    LocalDate date = LocalDate.parse("2018-06-06");
    date.minusDays(10);
    System.out.println(date);
    assertEquals("2018-06-06", date.toString());
  }

  @Test(timeout = 1000)
  public void dateSubstractionImmutable() throws Exception {
    LocalDate date = LocalDate.parse("2000-06-25");
    while (date.getDayOfMonth() >= 20) {
      System.out.println(date);
      date.plusDays(-1);
    }
  }

  /**
   * {@link LocalDate#withDayOfYear(int)} documentation: Returns a copy of this LocalDate with the
   * day-of-year altered.
   * 
   * @throws Exception
   */
  @Test
  public void withDayOfYear() throws Exception {
    LocalDate joiningDate = LocalDate.parse("2006-03-16");
    LocalDate withDayOfYear = joiningDate.withDayOfYear(29);
    System.out.println();
    assertEquals("2006-01-29", withDayOfYear.toString());
  }

  /**
   * Constructor of LocalDate can not be called directly. We have to use
   * {@link LocalDate#of(int, int, int)} or {@link LocalDate#parse(CharSequence)} factory method.
   * 
   * @throws Exception
   */
  @Test
  public void dateMinusPeriod() throws Exception {
    LocalDate obj = LocalDate.of(2020, 2, 14);
    // LocalDate obj = new LocalDate(2020, 2, 14);
    System.out.println(obj.minus(Period.ofDays(10)));
  }

  /**
   * Read carefully description of {@link Period#parse(CharSequence)} method. P, Y, M, D and W
   * placeholders are case insensitive. And minus sign actually applies negative value to the parsed
   * component of the period.
   * 
   * In the case below parsed period will be -3000 years.
   * 
   * 2000-30000 = -28000
   * 
   * {@link LocalDate#plus(java.time.temporal.TemporalAmount)} method accepts negative and positive
   * values.
   * 
   * The result is "-28000-01-01"
   * 
   * @throws Exception
   */
  @Test
  public void addPeriodToDate() throws Exception {
    LocalDate date = LocalDate.of(2000, Month.JANUARY, 1);
    Period period = Period.parse("p-30000y");
    LocalDate substractedDate = date.plus(period);
    System.out.println();
    assertEquals("-28000-01-01", substractedDate.toString());
  }
}
