package com.rivancic.java.basic;

import org.junit.Test;

/**
 * How argument values are assigned to formal parameters.
 * https://docs.oracle.com/javase/specs/jls/se8/html/jls-5.html#jls-5.3
 * 
 * Rules:
 * <ol>
 * <li>an identity conversion (§5.1.1)</li>
 * <li>a widening primitive conversion (§5.1.2)</li>
 * <li>a widening reference conversion (§5.1.5)</li>
 * <li>a boxing conversion (§5.1.7) optionally followed by widening reference conversion</li>
 * <li>an unboxing conversion (§5.1.8) optionally followed by a widening primitive conversion</li>
 * </ol>
 * 
 * https://stackoverflow.com/questions/7014171/widening-and-boxing-java-primitives
 * 
 * @author Renato Ivancic <r.ivancic@dodax.com>
 *
 */
public class MethodOverloadTest {
  public static String add(Object... vals) {
    return "Varargs Object";
  }

  public static String add(Object vals) {
    return "Object";
  }

  public static String addLong(Long vals) {
    return "Long";
  }

  public static String addLong(long... vals) {
    return "long...";
  }


  @Test
  public void testName() throws Exception {
    String[] objects = {"Bla", "Bla"};
    System.out.println(MethodOverloadTest.add(objects));

    int[] ints = {1, 2};
    System.out.println(MethodOverloadTest.add(ints));

    Integer[] wrappedInts = {1, 2};
    System.out.println(MethodOverloadTest.add(wrappedInts));

    Integer wrappedInteger = 1;
    System.out.println(MethodOverloadTest.addLong(wrappedInteger));
  }
}
