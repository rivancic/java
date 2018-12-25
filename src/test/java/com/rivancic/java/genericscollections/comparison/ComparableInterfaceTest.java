package com.rivancic.java.genericscollections.comparison;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

/**
 * <p>
 * If classes implement comparable they can be used in data structured that require comparison.
 * Comparable is functional interface. The only public abstract method is
 * {@link Comparable#compareTo(Object).}
 * </p>
 * <p>
 * The number 0 is returned when the objects are the same Negative number is returned if the current
 * object is smaller than the argument. Positive number greater than zero is returned when the
 * compared object is greater that the one passed in the argument.
 * </p>
 * Note that {@link Comparable} is implemented in <b>java.lang</b>
 * 
 * @author rivancic
 *
 */
public class ComparableInterfaceTest {

  /**
   * Example of sorting the Collection of Comparable generic type with the
   * {@link Collections#sort(List)} method.
   */
  @Test
  public void comparableExample() {
    List<Voucher> vouchers =
      Arrays.asList(new Voucher("SUMMER2018", false), new Voucher("CYBERMONDAY", true),
        new Voucher("LEARNJAVA", false));
    Collections.sort(vouchers);
    System.out.println(vouchers);
    assertEquals("CYBERMONDAY", vouchers.get(0).getName());
    assertEquals("SUMMER2018", vouchers.get(1).getName());
    assertEquals("LEARNJAVA", vouchers.get(2).getName());
  }
}
