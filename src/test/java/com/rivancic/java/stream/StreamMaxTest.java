package com.rivancic.java.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import org.junit.Test;

public class StreamMaxTest {

  @Test
  public void publicStreamMax() {
    List<Integer> list = Arrays.asList(10, 20, 8);

    System.out.println(list.stream().max(Comparator.comparing(a -> a)).get()); //Line 1

    System.out.println(list.stream().max(Integer::compare).get()); //Line 2

    System.out.println(list.stream().max(Integer::max).get()); //Line 3
  }
}
