package com.rivancic.java.genericscollections.queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.NoSuchElementException;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ArrayDequeAsStackTest {

  @Test
  public void stackTest() {

    // given
    // Empty ArrayDeque
    Deque<String> stack = new ArrayDeque<String>();

    // when
    // Using stack methods one can use ArrayDeque as a stack.
    // This is also more performant as deprecated {@link java.util.Stack}.
    // Stack methods are
    // push -> add element to head
    // pop -> remove element from head -> throwing exception if empty
    // peek -> get value of the head element without removing it
    stack.push("A");
    stack.push("B");
    Assertions.assertThat(stack.peek()).isEqualTo("B");
    Assertions.assertThat(stack.pop()).isEqualTo("B");
    Assertions.assertThat(stack.peek()).isEqualTo("A");
    Assertions.assertThat(stack.pop()).isEqualTo("A");
    Assertions.assertThat(stack.peek()).isEqualTo(null);

    try{
      stack.pop();
    } catch (NoSuchElementException noSuchElementException) {
      Assertions.assertThat(true).isEqualTo(true);
    }

  }
}
