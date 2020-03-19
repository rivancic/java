package com.rivancic.java.stream;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class AnyMatchTest {

  @Test
  public void anyMatch() {
    int ref = 10;
    List<Integer> list = new ArrayList<>();
    list.stream().anyMatch(i -> {
      System.out.println("HELLO");
      return i > ref;
    });
  }
}
