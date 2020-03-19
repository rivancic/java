package com.rivancic.java.genericscollections;

import static org.junit.Assert.*;
import java.util.ArrayDeque;
import java.util.Deque;
import org.junit.Test;

/**
 * 
 * @author rivancic
 *
 */
public class DequeTest {

  /**
   * If Deque is empty then remove will Throw exception
   */
 @Test
  public void dequeRemoveEmptyExceptionTest() {
      Deque<Character> chars = new ArrayDeque<>();
      chars.add('A');
      chars.remove();
      chars.remove();
      System.out.println(chars);
  }
  
  /**
   * FIFO implementation with the ArrayDeque.
   */
  @Test
  public void dequeFIFOTest() {
    ArrayDeque<String> arrayDeque = new ArrayDeque<String>();
    arrayDeque.offer("First");
    arrayDeque.offer("Second");
    arrayDeque.offer("Last");
    assertEquals("First", arrayDeque.poll());
    assertEquals("Second", arrayDeque.poll());
    assertEquals("Last", arrayDeque.poll());
  }
  
  /**
   * FIFO implementation with the ArrayDeque.
   */
  @Test
  public void dequeLIFOTest() {
    ArrayDeque<String> arrayDeque = new ArrayDeque<String>();
    arrayDeque.offer("First");
    arrayDeque.offer("Second");
    arrayDeque.offer("Last");
    assertEquals("Last", arrayDeque.pollLast());
    assertEquals("Second", arrayDeque.pollLast());
    assertEquals("First", arrayDeque.pollLast());
  }
}
