package com.rivancic.java.basic;

import static org.junit.Assert.assertEquals;
import com.rivancic.java.a.A1;
import org.junit.Test;

public class InheritanceTest {

  class B extends A1 {
    public void print() {
      A1 obj = new A1();
      System.out.println(obj.i1); // Line 8
      // System.out.println(obj.i2); // Line 9 has to be commented because the field is not visible.
      System.out.println(this.i2); // Line 10
      System.out.println(super.i2); // Line 11
    }
  }


  @Test
  public void testInheritance() throws Exception {
    new B().print();
  }

  class Parent {
    public String toString() {
      return "Inner ";
    }
  }

  class Child extends Parent {
    public String toString() {
      return super.toString().concat("Peace!");
    }
  }


  @Test
  public void testToStingMethod() throws Exception {
    System.out.println(new Child());
    assertEquals("Inner Peace!", new Child().toString());
  }
}
