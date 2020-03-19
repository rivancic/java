package com.rivancic.java.basic;

import org.junit.Test;

public class AnonymousInnerClass {

  /**
   * It creates anonymous class extending Object type with overriden toString method that prints
   * Anonymous when the instance of the ogject is passed to System.out.print method
   */
  @Test
  public void anonymousInnerClass() {
    System.out.println(new Object() {
      public String toString() {
        return "Anonymous";
      }
    });
  }
}
