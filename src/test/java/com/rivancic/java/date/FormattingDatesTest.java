package com.rivancic.java.date;

import static org.junit.Assert.assertEquals;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.UnsupportedTemporalTypeException;
import java.util.Date;
import org.junit.Test;

/**
 * Topics: SimpleDateFormat, Date (Java 7), DateTimeFormatter, LocalDateTime
 * 
 * @author Renato Ivancic <r.ivancic@dodax.com>
 *
 */
public class FormattingDatesTest {

  /**
   * Formatting date with java 7 classes.
   */
  @Test
  public void testDate7() {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/M/yyyy");
    String formatedDate = dateFormat.format(new Date());
    System.out.println("Formated date: " + formatedDate); // Formated date: 01/6/2018
  }

  /**
   * Formatting date with Java 8 classes.
   */
  @Test
  public void testDate8() {
    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/M/yyy");
    String formatedDate = LocalDateTime.now().format(dateFormat);
    System.out.println("Formated date: " + formatedDate); // Formated date: 01/6/2018
  }

  /**
   * LocalDate can not be formatted with the time component.
   * 
   * @throws Exception
   */
  @Test(expected = UnsupportedTemporalTypeException.class)
  public void localDateWithTimeFormat() throws Exception {
    System.out.println(LocalDate.parse("1987-09-01").format(
      DateTimeFormatter.ISO_DATE_TIME));
  }

  /**
   * First line gets executed correctly. DateTime instance is created with the help of factory
   * method. In next line DateTimeFormatter that will display date component with full details is
   * created. At the end the date component will be printed with day and month printed with words.
   * No time component will be printed even if LocalDateTime contains it.
   * 
   * Result will be: Tuesday, January 1, 2019
   * 
   * @throws Exception
   */
  @Test
  public void testOfLocalizedDateMethod() throws Exception {
    LocalDateTime date = LocalDateTime.of(2019, 1, 1, 10, 10);
    DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
    assertEquals("Tuesday, January 1, 2019", formatter.format(date));
  }
}
