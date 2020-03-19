package com.rivancic.java.genericscollections.queue;

import com.rivancic.java.genericscollections.list.Student;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import org.junit.Test;

public class ArrayDequeTest {

  /**
   * In array Deque null elements are prohibited. On null element the null pointer is being thrown.
   */
  @Test(expected = NullPointerException.class)
  public void test() {

    // given
    List<String> list = Arrays.asList("oca", null, "ocp", "java", "null"); //Line n1
    // when

    Deque<String> deque = new ArrayDeque<String>(list); //Line n2


    // then
    System.out.println(deque.size()); //Line n3
  }
}
