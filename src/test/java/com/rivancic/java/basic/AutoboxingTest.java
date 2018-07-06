package com.rivancic.java.basic;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class AutoboxingTest {

  /**
   * This one seems like an easy solution but in reality its quite tricky. Do you know what happens
   * under the hood?
   * 
   * In specification you can find paragraph that describes which unboxing values will yield the
   * same value.
   * <a href="https://docs.oracle.com/javase/specs/jls/se7/html/jls-5.html#jls-5.1.7">5.1.7. Boxing
   * Conversion</a>
   * 
   * If the value p being boxed is true, false, a byte, or a char in the range \u0000 to \u007f, or
   * an int or short number between -128 and 127 (inclusive), then let r1 and r2 be the results of
   * any two boxing conversions of p. It is always the case that r1 == r2.
   * 
   * @throws Exception
   */
  @Test
  public void valueReferenceComparison() throws Exception {
    List<Integer> list = new ArrayList<Integer>();

    // Will result in same reference as smaller ints are being cached.
    list.add(27);
    list.add(27);

    list.add(new Integer(27));
    list.add(new Integer(27));


    boolean firstComparison = list.get(0) == list.get(1);
    boolean secondComparison = list.get(2) == list.get(3);

    assertEquals(true, firstComparison);
    assertEquals(false, secondComparison);
  }

  private static void add(double d1, double d2) {
    System.out.println("double version: " + (d1 + d2));
  }

  private static void add(Double d1, Double d2) {
    System.out.println("Double version: " + (d1 + d2));
  }

  /**
   * <p>
   * First argument is double and second Integer which will be automatically unboxed to double.
   * </p>
   * 
   * Unboxing happens when converting an object of a wrapper type (Integer) to its corresponding
   * primitive (int) value is called unboxing. The Java compiler applies unboxing when an object of
   * a wrapper class is:
   * 
   * Passed as a parameter to a method that expects a value of the corresponding primitive type.
   * Assigned to a variable of the corresponding primitive type.
   * 
   * Integer will not be transformed to Double only to primitive double so the add(double, double)
   * will be called.
   * 
   * 
   * TODO need to ask on forum for further explanation
   * 
   * @throws Exception
   */
  @Test
  public void callMethodWithPrimitiveOrWrappedType() throws Exception {
    // Why add(double, double), what is the order of evaluating the expression
    add(10.0, new Integer(10));
    // Why add(double, double), what is the order of evaluating the expression
    add(new Double(10.0), new Integer(10));

    // Null can not be set to double so both values are getting autoboxed into Double.
    add(10.0, null);

    // Why is this throwing compilation error, compile could have rule to select one, like in the
    // above examples, add(double, double)
    // add(10.0, new Double(10.0));
  }

  /**
   * Null can not be set to double so both values are getting autoboxed into Double. The method will
   * be called but as a result of adding value with null an NullPointerException will be thrown
   * 
   * @throws Exception
   */
  @Test(expected = NullPointerException.class)
  public void callMethodWithPrimitiveOrWrappedTypeNullPointerThrown() throws Exception {

    add(10.0, null);
  }

  @Test
  public void autoboxingCharsInIntArray() throws Exception {
    int[] arr1 = {1, 2, 3};
    int[] arr2 = {'A', 'B'}; // ASCII code of 'A' is 65, 'B' is 66
    arr1 = arr2;
    for (int i = 0; i < arr1.length; i++) {
      System.out.print(arr1[i] + " ");
    }
  }
}
