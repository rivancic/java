package com.rivancic.java.io;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import org.junit.Test;

public class PrintFormatTest {
  @Test
    public void test() {
    System.out.format("A%nB%nC");
  }

  @Test
  public void iteratorTest() {
    List<String> list = Arrays.asList("T", "S", "R", "I", "F");
    ListIterator<String> iter = list.listIterator(3);
    while(iter.hasPrevious()) {
      System.out.print(iter.previous());
    }
    System.out.format("%n");
    ListIterator<String> iter1 = list.listIterator(3);
    while(iter1.hasNext()) {
      System.out.print(iter1.next());
    }
  }
}