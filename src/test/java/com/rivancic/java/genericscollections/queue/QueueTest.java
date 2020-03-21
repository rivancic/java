package com.rivancic.java.genericscollections.queue;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class QueueTest {

  /**
   * Remove method form Queue with one parameter comes form the Collection interface and it accepts
   * the Object parameter.
   *
   * The remove method from Queue class does not have any parameters and it removes elements form
   * the head.
   */
  @Test
  public void queueRemovalTest() {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(10);
    queue.add(12);

    /**
     * Nothing will be removed as remove method is coming from {@link java.util.Collection#remove(Object)}.
     * As queue does not contain any integer object 1, nothing gets removed. Both objects 10 and 12 are still part of the queue.
     */
    queue.remove(1);
    System.out.println(queue);
    assertThat(queue.size()).isEqualTo(2);
    assertThat(queue.peek()).isEqualTo(10);
  }

  /**
   * Elements are inserted into {@link Queue} at the tail. Elements are removed from the Queue form
   * the head. They are functioning in a FIFO princip.
   *
   * For the {@link List} {@link List#remove(int)} method is used to remove element which is
   * removing an element at the parameter index of 1.
   */
  @Test
  public void queueHeadRemoval() {
    List<String> list = new LinkedList<>();
    list.add("ONE");
    list.add("TWO");
    list.remove(1);

    Queue<String> queue = new LinkedList<>();
    queue.add("ONE");
    queue.add("TWO");
    queue.remove();

    Assertions.assertThat(list).containsExactly("ONE");
    Assertions.assertThat(queue).containsExactly("TWO");
  }
}
