package com.rivancic.java.stream;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class Filter7Test {

  @Test
  public void test() {
    List<String> list = Arrays.asList("7 Seven", "Lucky 7", "77", "O7ne");
    list.stream().filter(str -> str.contains("7"))
      .forEach(System.out::println);
  }
}
