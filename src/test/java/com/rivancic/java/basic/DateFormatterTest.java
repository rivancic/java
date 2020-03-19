package com.rivancic.java.basic;

import java.text.NumberFormat;
import java.text.ParseException;
import java.time.DateTimeException;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import org.junit.Test;

public class DateFormatterTest {

  /**
   * As text representation of date does not contain two decimals for a month it can not be parsed correctly.
   * DateTimeException runtime exception will be thrown.
   *
   */
  @Test(expected = DateTimeException.class)
  public void dateFormatTest() {
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-uuuu");
    System.out.println(dateFormatter.parse("10-5-2019"));
  }

  /**
   * Parsing text with NumberFormat {@link NumberFormat#parse(String)} is throwing checked ParseException.
   * It has to be handled in try catch statement or being rethrown.
   */
  @Test
  public void numberFormatTest() throws ParseException {

    // US currency format
    NumberFormat usCurrFormatter = NumberFormat.getCurrencyInstance(Locale.US);
    System.out.println(usCurrFormatter.parse("$7.00"));

    // Slovenian currency format
    NumberFormat siCurrFormat = NumberFormat.getCurrencyInstance(new Locale("sl", "SI"));
    System.out.println(siCurrFormat.format(10.10));
    System.out.println(siCurrFormat.parse("€ 10,1"));

    // Hungarian currency format
    NumberFormat huCurrFormat = NumberFormat.getCurrencyInstance(new Locale("hu", "HU"));
    System.out.println(huCurrFormat.format(10.10));
    System.out.println(huCurrFormat.parse("10,1 Ft"));

  }
}
