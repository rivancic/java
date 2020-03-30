package com.rivancic.java.genericscollections.list;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * From example you can see LinkedList implements Queue and List interfaces.
 */
public class LinkedListTest {

  /**
   * LinkedList#remove(int) removes item at the position x.
   */
  @Test
  public void linkedListListRemovalTest() {

    // given
    List<Integer> list = new LinkedList<>(Arrays.asList(10,12));

    // when
    list.remove(1);

    // then
    Assertions.assertThat(list).containsExactly(10);
  }

  /**
   * LinkedList#remove(Object) actually comes form Collection. And tries to remove specific item form the
   * collection. As there is no 1 in the queue nothing will be removed.
   * With Queue reference the method overriden form Queue will be invoked in LinkedList.
   */
  @Test
  public void linkedListQueueRemovalTest() {

    // given
    Queue<Integer> queue = new LinkedList<>(Arrays.asList(10,12));

    // when
    queue.remove(1);

    // then
    Assertions.assertThat(queue).containsExactly(10,12);
  }
}
