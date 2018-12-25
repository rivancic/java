package com.rivancic.java.genericscollections.list;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class RemoveIfTest {

  /**
   * The list method removeIf accepts a Predicate as a parameter and because parameter returns true
   * when the year is less than 2000.
   * 
   * @throws Exception
   */
  @Test
  public void testremoveIfMethodOfList() throws Exception {
    List<LocalDate> dates = new ArrayList<>();
    dates.add(LocalDate.parse("2018-07-11"));
    dates.add(LocalDate.parse("1919-02-25"));
    dates.add(LocalDate.of(2020, 4, 8));
    dates.add(LocalDate.of(1980, Month.DECEMBER, 31));
    dates.removeIf(x -> x.getYear() < 2000);
    System.out.println(dates);
  }
}
