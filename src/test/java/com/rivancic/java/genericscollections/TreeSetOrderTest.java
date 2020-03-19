package com.rivancic.java.genericscollections;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;

public class TreeSetOrderTest {

  @Test
  public void test() {
  Stream<String> stream = Stream.of("java", "python", "c",
    "c++", "java", "python");
  Set<String> set = stream.collect(Collectors.toCollection(TreeSet::new));
        System.out.println(set);
  }
}
