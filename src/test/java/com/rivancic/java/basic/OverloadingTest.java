package com.rivancic.java.basic;

import org.junit.Test;

public class OverloadingTest {

  class Octopus {
    public void munch(String s) {

    }
  }

  class BabyOctopus extends Octopus {
    public void munch(Object s) {
      System.out.println("munched an object");
    }
  }

  @Test
  public void test() {

    BabyOctopus b = new BabyOctopus();
    b.munch("j");
  }
}
