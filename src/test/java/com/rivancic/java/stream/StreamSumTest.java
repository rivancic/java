package com.rivancic.java.stream;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.Test;

public class StreamSumTest {

  @Test
  public void sum(){
    Stream<Integer> stream = Arrays.asList(1,2,3,4,5).stream();
    // sum is not final Stream method System.out.println(stream.sum());
    // One can call sum() on IntStream type IntStream#sum();


  }
}
