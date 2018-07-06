package com.rivancic.java.string;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class StringReplaceTest {

  @Test
  public void listTest() throws Exception {
    String s = new String("Hello");
    List<String> list = new ArrayList<>();
    list.add(s);
    list.add(new String("Hello"));
    list.add(s);
    s.replace("l", "L");
    System.out.println(list);
  }
}
