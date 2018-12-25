package com.rivancic.java.testdome;

import org.junit.Test;

public class TrainTest {



  /**
   * public static void main(String[] args) { Train train = new Train(10, wagonIndex -> wagonIndex);
   * 
   * for (int i = 0; i < 10; i++) { System.out.println("Wagon: " + i + ", cargo: " +
   * train.peekWagon(i)); } }
   */

  @Test
  public void testName() throws Exception {
    Train train = new Train(10, wagonIndex -> wagonIndex);

    for (int i = 0; i < 10; i++) {
      System.out.println("Wagon: " + i + ", cargo: " + train.peekWagon(i));
    }
  }
}

