package com.rivancic.java.basic;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class TypeTest {
  char c;
  double d;
  float f;

  /**
   * The following is the output. Default values initialization applies for the types.<br>
   * https://docs.oracle.com/javase/specs/jls/se7/html/jls-4.html#jls-4.12.5
   * 
   * <pre>
   * >
   * >0.0
   * >0.0
   * </pre>
   * 
   * @throws Exception
   */
  @Test
  public void testDefaultVariableValues() throws Exception {
    TypeTest obj = new TypeTest();
    System.out.println(">" + obj.c);
    System.out.println(">" + obj.d);
    System.out.println(">" + obj.f);
  }

  /**
   * Integer value can be wrapped into char.<br>
   * char 16 bits [range 0 to 216-1 or \u0000 to \uFFFF]<br>
   * Actually char is signed 2 bytes so it can hold 64000 max number
   * 
   * @throws Exception
   */
  @Test
  public void charSwitch() throws Exception {
    char var = 64000;
    switch (var) {
      case 64000:
        System.out.println("Lucky no. 7");
        break;
      default:
        System.out.println("DEFAULT");
    }
  }

  /**
   * Comparison returns false because new StringBuilder is a reference to new object and
   * StringBuilder equals method does not evaluate String value that can be build with the
   * StringBuilder.
   * 
   * @throws Exception
   */
  @Test
  public void testName() throws Exception {
    List<StringBuilder> days = new ArrayList<>();
    days.add(new StringBuilder("Sunday"));
    days.add(new StringBuilder("Monday"));
    days.add(new StringBuilder("Tuesday"));

    if (days.contains(new StringBuilder("Sunday"))) {
      days.add(new StringBuilder("Wednesday"));
    }

    System.out.println(days.size());
  }

  /**
   * Parameter int will be wrapped into Number type.<br>
   * If there would be method with Integer type int parameter would be wrapped into Integer type. In
   * case there is no Number and Integer parameter methods the int would be wrapped into Object
   * type.
   * 
   * @throws Exception
   */
  @Test
  public void whichMethodWillBeInvoked() throws Exception {
    m(1);
  }

  private static void m(Object obj) {
    System.out.println("Object version");
  }

  private static void m(Number obj) {
    System.out.println("Number version");
  }

  /*
   * private static void m(Integer obj) { System.out.println("Integer version"); }
   */

  private static void m(Double obj) {
    System.out.println("Double version");
  }
}
