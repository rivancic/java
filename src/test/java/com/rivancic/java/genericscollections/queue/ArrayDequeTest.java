package com.rivancic.java.genericscollections.queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ArrayDequeTest {

  /**
   * In array Deque null elements are prohibited. On null element the null pointer is being thrown.
   */
  @Test(expected = NullPointerException.class)
  public void test() {

    // given
    List<String> list = Arrays.asList("oca", null, "ocp", "java", "null");

    // when
    Deque<String> deque = new ArrayDeque<>(list);

    // then
    // exception is thrown as ArrayDeque does not support null values.
  }


  /**
   * In array Deque null elements are prohibited. On null element the null pointer is being thrown.
   */
  @Test
  public void testArrayDequeOperations() {

    // given
    List<String> list = Arrays.asList("A", "B", "C", "D");
    Deque<String> deque = new ArrayDeque<>(list);

    // when
    Assertions.assertThat(deque.peek()).isEqualTo("A");
    Assertions.assertThat(deque.peekFirst()).isEqualTo("A");

    Assertions.assertThat(deque.peekLast()).isEqualTo("D");



    // then
    // exception is thrown as ArrayDeque does not support null values.
  }
}
