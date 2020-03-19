package com.rivancic.java.basic;

import java.util.stream.IntStream;
import org.junit.Test;

enum Flags1 {
  TRUE, FALSE;

  Flags1() {
    System.out.println("HELLO");
  }
}


public class ConstructorInitializationTest {
  @Test
  public void constructorInitializationTest() {
    Flags1 flags = Flags1.TRUE;
  }

}
