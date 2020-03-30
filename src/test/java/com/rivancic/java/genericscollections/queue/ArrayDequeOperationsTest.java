package com.rivancic.java.genericscollections.queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.TreeMap;
import java.util.TreeSet;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ArrayDequeOperationsTest {

  @Test
  public void pushPopPeekMethodTest() {

    // given
    Deque<String> deque = new ArrayDeque<String>(Arrays.asList("A", "B", "C", "D"));

    // when
    // push method adds elements to the head of the queue
    // this means 9 will be added before A
    deque.push("9");
    deque.push("8");

    // null pointer
    //deque.push(null);

    // removes first element form the head of the queue
    deque.pop();

    String currentItem = deque.peek();


    // then
    Assertions.assertThat(currentItem).isEqualTo("9");
    Assertions.assertThat(deque.pop()).isEqualTo("9");
    Assertions.assertThat(deque.pop()).isEqualTo("A");
    Assertions.assertThat(deque.pop()).isEqualTo("B");
    Assertions.assertThat(deque.pop()).isEqualTo("C");
    Assertions.assertThat(deque.pop()).isEqualTo("D");
  }

  @Test(expected = NoSuchElementException.class)
  public void popEmptyTest() {

    // given
    Deque<String> deque = new ArrayDeque<String>();
    deque.push("A");

    // when
    deque.pop();
    deque.pop();


    // then
    // exception will be thrown as no element is present in the queue
  }

  @Test
  public void peekEmptyTest() {

    // given
    Deque<String> deque = new ArrayDeque<String>();
    deque.push("A");

    // when
    deque.pop();
    String peekResultWhenDequeIsEmpty = deque.peek();


    // then
    Assertions.assertThat(peekResultWhenDequeIsEmpty).isEqualTo(null);
  }

  @Test
  public void removeTest() {

    // given
    Deque<String> deque = new ArrayDeque<String>();
    deque.push("A");
    deque.offer("B");
    deque.addLast("C");

    // when
    String firstElement= deque.remove();
    deque.remove();
    String lastElement= deque.remove();

    // then
    Assertions.assertThat(firstElement).isEqualTo("A");
    Assertions.assertThat(lastElement).isEqualTo("C");
  }

  /**
   * If remove is called when the queue is empty {@link NoSuchElementException} will be thrown
   * The same happens with pop.
   */
  @Test(expected =NoSuchElementException.class)
  public void removeAfterLastTest() {

    // given
    Deque<String> deque = new ArrayDeque<String>();
    deque.push("A");
    deque.add("B"); // Like offer but throws exception if capacity full and queue is restricted.


    // when
    deque.remove(); // A
    deque.remove(); // B
    deque.poll(); // null
    deque.remove(); // NoSuchElementException

    // then
    // exception will be thrown as no element is present in the queue
  }
}
