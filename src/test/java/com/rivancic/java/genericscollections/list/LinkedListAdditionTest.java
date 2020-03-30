package com.rivancic.java.genericscollections.list;

import java.util.LinkedList;
import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * One can persist duplicated values as well as null values in a {@link LinkedList}
 */
public class LinkedListAdditionTest {

  @Test
  public void linkedListListAdditionTest() {

    // given
    LinkedList<Integer> linkedList = new LinkedList<>();
    linkedList.add(4);
    linkedList.add(4);
    linkedList.add(6);
    linkedList.add(null);

    // then
    Assertions.assertThat(linkedList).containsExactly(4,4,6,null);
  }
}
