package com.rivancic.java.genericscollections;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class ListReplaceAllTest {

  @Test
  public void listReplaceTest() {
    List<String> list = Arrays.asList("north", "east", "west", "south");
    list.replaceAll(s -> s.substring(0,1).toUpperCase().concat(s.substring(1)));
    System.out.println(list);
  }
}
