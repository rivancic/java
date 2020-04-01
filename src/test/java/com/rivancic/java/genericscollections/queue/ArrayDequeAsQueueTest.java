package com.rivancic.java.genericscollections.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ArrayDequeAsQueueTest {

  @Test
  public void queueTest() {

    // given
    // Empty ArrayDeque
    Deque<String> stack = new ArrayDeque<String>();

    // when
    // Using queue methods one can use ArrayDeque as a queue.
    //
    // queue methods are
    // offer -> add element to tail (no exception)
    // poll -> remove element form head (no exception)
    // peek -> get value of the head element without removing it
    stack.offer("A");
    stack.offer("B");
    Assertions.assertThat(stack.peek()).isEqualTo("A");
    Assertions.assertThat(stack.poll()).isEqualTo("A");
    Assertions.assertThat(stack.peek()).isEqualTo("B");
    Assertions.assertThat(stack.poll()).isEqualTo("B");
    Assertions.assertThat(stack.peek()).isEqualTo(null);
    Assertions.assertThat(stack.poll()).isEqualTo(null);
  }
}
