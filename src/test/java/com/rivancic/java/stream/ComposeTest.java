package com.rivancic.java.stream;

import java.io.PrintWriter;
import java.util.function.Function;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ComposeTest {

  /**
   * With compose first parameter function gets executed and then the function itself
   *
   * With andThen functions get executed in an order
   */
  @Test
    public void composeTest() {

    // given
    Function<Integer, Integer> times2 = e -> e * 2;
    Function<Integer, Integer> squared = e -> e * e;

    Integer composeResult = times2.compose(squared).apply(4);
    Integer andThenResult = times2.andThen(squared).apply(4);

    try(PrintWriter pw=null) {
      System.out.println("HELLO");
    }

    // then
    Assertions.assertThat(composeResult).isEqualTo(32);
    Assertions.assertThat(andThenResult).isEqualTo(64);
  }
}
