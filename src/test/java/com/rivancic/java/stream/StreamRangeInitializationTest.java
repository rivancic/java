package com.rivancic.java.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class StreamRangeInitializationTest {

  /**
   * Upper limit is exclusive in range creation
   */
  @Test
  public void openRangeTest() {
    List<Integer> openRangedStream = IntStream.range(1, 3).boxed().collect(Collectors.toList());
    Assertions.assertThat(openRangedStream).containsExactly(1,2);
  }

  /**
   * At closed range stream the upper boundary is inclusive
   */
  @Test
  public void closedRangeTest() {
    List<Integer> closedRangeStream = IntStream.rangeClosed(1, 3).boxed().collect(Collectors.toList());
    Assertions.assertThat(closedRangeStream).containsExactly(1,2,3);
  }
}
