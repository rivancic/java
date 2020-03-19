package com.rivancic.java;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

/**
 * LinkedHashMap is keeping its elements in order in which they were inserted.
 *
 * map only has forEach method accepting BiConsumer lambda function. It does not contain
 * .forEachOrdered(), this one is in Stream class.
 *
 * The result will be
 * 1:10
 * 2:20
 *
 */
public class LinkedHashMapOrderTest {

  public static void main(String[] args) {
    Map<Integer, Integer> map = new LinkedHashMap<>();
    map.put(1, 10);
    map.put(2, 20);
    BiConsumer<Integer, Integer> consumer = (k, v) -> {
      System.out.println(k + ":" + v);
    };

    BiFunction<Integer, Integer, Integer> function = (k, v) -> {
      System.out.println(k + ":" + v);
      return null;
    };
    map.forEach(consumer);
    // wrong, map.forEachOrdered()
  }
}