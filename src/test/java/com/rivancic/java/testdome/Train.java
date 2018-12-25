package com.rivancic.java.testdome;

import java.util.function.Function;

public class Train {

  private int[] wagons;

  public Train(int wagonCount, Function<Integer, Integer> fillWagon) {
    this.wagons = new int[wagonCount];

    for (int i = 0; i < wagonCount; i++) {
      this.wagons[i] = fillWagon.apply(i);
    }
  }

  public int peekWagon(int wagonIndex) {
    return this.wagons[wagonIndex];
  }
}
