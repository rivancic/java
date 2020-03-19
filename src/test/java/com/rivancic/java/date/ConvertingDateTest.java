package com.rivancic.java.date;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import org.junit.Test;

public class ConvertingDateTest {

  /**
   * Date and LocalDate do not have any convenient methods to convert one to another.
   * The way of how to do it is to convert date to Instant and assign a zone to it.
   * Then it can be converted to LocalDateTime
   *
   * Instant#atZone give us a ZonedDateTime.
   */
  @Test
  public void convertDateTest() {
    Date date = new Date();

    // LocalDate localDate1 = (LocalDate) date; // Dates are inconvertible Date is not a subclass of LocalDate

    LocalDate localDate2 = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

    LocalDate localDate3 = Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();

    // LocalDate localDate4 = LocalDate.of(date); // This method does not exist
  }
}
