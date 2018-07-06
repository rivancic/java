package com.rivancic.java.exceptions;

import org.junit.Test;

public class ExceptionWithInheritanceTest {

  class Base {
    public void m1() throws NullPointerException {
      System.out.println("Base: m1()");
    }
  }

  /**
   * Method m1 is overridden from the Base class. It has the same signature. Overridden method can
   * only have more permissive access modifiers. For example m1 can be public but not any of other
   * less permissive access types like protected, default or private.
   * 
   * @author Renato Ivancic <r.ivancic@dodax.com>
   *
   */
  class Derived extends Base {
    public void m1() throws RuntimeException {
      System.out.println("Derived: m1()");
    }
  }

  /**
   * The m1 method on Derived gets called. Thats the polymorphism in action. You can do that
   * assignment because a Derived is a Base, but the runtime is smart enough to know that the actual
   * type of obj is Derived. M1 method is overridden in Derived class.
   * 
   * @throws Exception
   */
  @Test
  public void testBaseDerivedException() throws Exception {
    Base obj = new Derived();
    obj.m1();
  }
}
