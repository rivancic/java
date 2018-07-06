package com.rivancic.java.basic;

import org.junit.Test;

/**
 * They belong to the block they are defined within, due of which <b>local inner classes</b> cannot
 * have any access modifiers associated with them. However, they can be marked as final or abstract.
 * These class have access to the fields of the class enclosing it.
 * 
 * Class B can be defined as: class B {} or final class B {}.
 * 
 * @author Renato Ivancic <r.ivancic@dodax.com>
 *
 */
public class InnerClassTest {

  class A {
    public void someMethod(final String name) {
      class B {
        void print() {
          System.out.println("Hello " + name);
        }
      }
      new B().print();
    }
  }

  @Test
  public void printPeriod() throws Exception {
    new A().someMethod("World!");
  }
}
