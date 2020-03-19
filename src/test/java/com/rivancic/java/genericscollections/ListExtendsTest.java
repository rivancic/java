package com.rivancic.java.genericscollections;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class ListExtendsTest {

  @Test
  public void extends1() {
    List<String> list1 = new ArrayList<>();
    list1.add("A");
    list1.add("B");

    List<? extends Object> list2 = list1;
    list2.remove("A"); //Line 13
   // list2.add("C"); //Line 14 Fails on line 14 as Extended collection can not add elements

    System.out.println(list2);
  }
}
