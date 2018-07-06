package com.rivancic.java.basic;

import com.rivancic.java.basic.test.Encapsulation;
import org.junit.Test;

public class EncapsulationTest {

  @Test
  public void encapsulationTest() throws Exception {
    Encapsulation obj = new Encapsulation(); // Line 7
    System.out.println(obj.i1); // Line 8
    // System.out.println(obj.i2); // Line 9 // Compilation error
    // System.out.println(obj.i3); // Line 10 // Compilation error
    // System.out.println(obj.i4); // Line 11 // Compilatino error
  }
}


abstract class Player {
  protected void play() {

  }

  abstract void run();
}


class FootballPlayer extends Player {
  protected void play() {

  }

  protected void run() {

  }
}
