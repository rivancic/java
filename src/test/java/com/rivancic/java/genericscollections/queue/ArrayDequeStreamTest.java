package com.rivancic.java.genericscollections.queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.TreeMap;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ArrayDequeStreamTest {

  /**
   * ArrayDeque implements collection interface which has stream() method.
   * For this reason one can get stream out of ArrayDeque.
   */
  @Test
  public void streamTest() {

    // given
    Deque<Integer> deque = new ArrayDeque<>(Arrays.asList(1, 2, 3, 4));

    // when
    // then
   deque.stream().filter(n -> n != 4).forEach(System.out::println);
  }
}
