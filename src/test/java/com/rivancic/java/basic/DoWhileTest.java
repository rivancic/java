package com.rivancic.java.basic;

import org.junit.Test;

public class DoWhileTest {

  @Test
  public void doWhileTest() {
    do {
      System.out.println(100);
    } while (false);
    System.out.println("Bye");
  }


  private static void m(int x) {
    System.out.println("int version, value of int: " + x);
  }

  private static void m(char x) {
    System.out.println("char version");
  }

  @Test
  public void intChar() throws Exception {
    int i = '5';
    m(i);
    m('5');
  }
}
