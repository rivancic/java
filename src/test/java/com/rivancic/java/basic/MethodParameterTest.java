package com.rivancic.java.basic;

import org.junit.Test;

public class MethodParameterTest {

  public static void change(int num) {
    num++;
    System.out.println(num);
  }

  @Test
  public void methodParameterTest() throws Exception {
    int i1 = 1;
    MethodParameterTest.change(i1);
    System.out.println(i1);
  }
}
