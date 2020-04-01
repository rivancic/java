package com.rivancic.java.genericscollections.queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * Different ways of initializing the arraydque.
 */
public class ArrayDequeInitializationTest {


  /**
   * Passing a list to the constructor. Under the hood it calls addAll method.
   */
  @Test
  public void constructorListTest() {

    // given
    List<String> list = Arrays.asList("A", "B", "C", "D");

    // when
    Deque<String> deque = new ArrayDeque<>(list);

    // then
    Assertions.assertThat(deque.pop()).isEqualTo("A");
    Assertions.assertThat(deque.pop()).isEqualTo("B");
    Assertions.assertThat(deque.pop()).isEqualTo("C");
    Assertions.assertThat(deque.pop()).isEqualTo("D");
  }

  /**
   * Different ways of initializing the arraydque.
   */
  @Test
  public void addAllMethodTest() {

    // given
    List<String> list = Arrays.asList("A", "B", "C", "D");

    // when
    Deque<String> deque = new ArrayDeque<>();
    deque.addAll(list);

    // then
    Assertions.assertThat(deque.pop()).isEqualTo("A");
    Assertions.assertThat(deque.pop()).isEqualTo("B");
    Assertions.assertThat(deque.pop()).isEqualTo("C");
    Assertions.assertThat(deque.pop()).isEqualTo("D");
  }
}
