package com.rivancic.java.date;

import static org.junit.Assert.assertEquals;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import org.junit.Test;

public class DateTest {


  /**
   * Will throw: java.time.DateTimeException: Invalid date 'SEPTEMBER 31'
   */
  @Test
  public void biggerDay() throws Exception {
    LocalDate date = LocalDate.of(2020, 9, 31);
    System.out.println(date);
  }

  /**
   * LocalTime.MIN = '00:00'<br>
   * LocalTime.MAX = '23:59:59.999999999'
   * 
   */
  @Test
  public void dateTest() {
    LocalDate date = LocalDate.parse("1947-08-14");
    LocalTime time = LocalTime.MAX;
    System.out.println(date.atTime(time));
  }


  /**
   * {@link LocalDateTime#getSecond()} returns the second-of-minute, from 0 to 59
   * 
   * @throws Exception
   */
  @Test
  public void testGetSeconds() throws Exception {
    LocalDateTime obj = LocalDateTime.now();
    System.out.println(obj.getSecond());
  }

  @Test
  public void dateComparison() throws Exception {
    LocalDate newYear = LocalDate.of(2018, 1, 1);
    LocalDate christmas = LocalDate.of(2018, 12, 25);
    boolean flag1 = newYear.isAfter(christmas);
    boolean flag2 = newYear.isBefore(christmas);
    System.out.println(flag1 + ":" + flag2);
  }

  @Test
  public void dateComparisonSameDate() throws Exception {
    LocalDate newYear = LocalDate.of(2018, 1, 1);
    LocalDate eventDate = LocalDate.of(2018, 1, 1);
    boolean flagNewYearIsAfterEventDate = newYear.isAfter(eventDate);
    boolean flagNewYearIsBeforeEventDate = newYear.isBefore(eventDate);
    boolean flagNewYearIsOnEventDate = newYear.isEqual(eventDate);
    System.out.println(flagNewYearIsAfterEventDate + ":" + flagNewYearIsBeforeEventDate);
    assertEquals(false, flagNewYearIsAfterEventDate);
    assertEquals(false, flagNewYearIsBeforeEventDate);
    assertEquals(true, flagNewYearIsOnEventDate);
  }

  /**
   * AM or PM<br>
   * Compilation error
   * 
   * @throws Exception
   */
  @Test
  public void testName() throws Exception {
    LocalTime time = LocalTime.of(16, 40);
    // String amPm = time.getHour() >= 12 ? (time.getHour() == 12) ? "PM" : "AM";
    // <System.out.println(amPm);
  }



  @Test
  public void removePeriod() throws Exception {
    LocalDate date = LocalDate.of(2012, 1, 11);
    Period period = Period.ofMonths(2);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yy");
    System.out.print(formatter.format(date.minus(period)));
  }


  @Test
  public void printPeriod() throws Exception {
    Period period = Period.of(0, 0, 0);
    System.out.println(period);
  }

  /**
   * It is valid to add negative period to the local date instance. In this case its the same as
   * subtracting positive value.
   * 
   * @throws Exception
   */
  @Test
  public void addNegativeInterval() throws Exception {

    // given
    LocalDate localDate = LocalDate.parse("2000-01-01");
    Period negativePeriodDays = Period.ofDays(-365);
    Period positivePeriodDays = Period.ofDays(-365);
    Period negativePeriodYears = Period.ofYears(-3000);
    Period positivePeriodYears = Period.ofYears(3000);

    // when
    LocalDate additionNegativeDays = localDate.plus(negativePeriodDays);
    LocalDate additionPositiveDays = localDate.plus(positivePeriodDays);
    LocalDate additionNegativeYears = localDate.plus(negativePeriodYears);
    LocalDate additionPositiveYears = localDate.plus(positivePeriodYears);


    // then
    assertEquals(localDate.parse("1999-01-01"), additionNegativeDays);
    assertEquals(localDate.parse("1999-01-01"), additionPositiveDays);
    assertEquals(localDate.parse("-1000-01-01"), additionNegativeYears);
    assertEquals(localDate.parse("5000-01-01"), additionPositiveYears);
  }

  /**
   * The test case will throw runtime exception because in formatting string mm stands for minutes
   * and in LocalDate there is no information for minutes.
   * 
   * @throws Exception
   */
  @Test
  public void minutesFormatTest() throws Exception {
    LocalDate date = LocalDate.of(2012, 1, 11);
    Period period = Period.ofMonths(2);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("mm-dd-yy");
    System.out.print(formatter.format(date.minus(period)));
  }

  /**
   * 24 hout is not valid, also invalid are values 60 and more for minutes and seconds. It will
   * throw
   * 
   * @param hour the hour-of-day to represent, from 0 to 23
   * @param minute the minute-of-hour to represent, from 0 to 59
   * @param second the second-of-minute to represent, from 0 to 59
   */
  @Test(expected = DateTimeException.class)
  public void testName1() {
    LocalTime time = LocalTime.of(23, 60, 10);
    System.out.println(time);
  }

  /**
   * All parse methods are executed successfully.
   * 
   * @throws Exception
   */
  @Test
  public void isoDateVsIsoLocalDate() throws Exception {
    LocalDate date1 = LocalDate.parse("1947-08-15", DateTimeFormatter.ISO_DATE);
    LocalDate date2 = LocalDate.parse("1947-08-15",
      DateTimeFormatter.ISO_LOCAL_DATE);
    LocalDate date3 = LocalDate.of(1947, 8, 15);
    System.out.println(date1.equals(date2) + " : " + date2.equals(date3));
  }
}
