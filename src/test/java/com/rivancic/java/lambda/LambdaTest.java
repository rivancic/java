package com.rivancic.java.lambda;

import java.util.function.Predicate;
import org.junit.Test;

public class LambdaTest {

  @Test
  public void testPredicate() {
    String[] arr = {"A", "ab", "bab", "Aa", "bb", "baba", "aba", "Abab"};
    Predicate<String> p = s -> s.toUpperCase().substring(0, 1).equals("A");
    processStringArray(arr, p);
  }

  private static void processStringArray(String[] arr,
    Predicate<String> predicate) {
    for (String str : arr) {
      if (predicate.test(str)) {
        System.out.println(str);
      }
    }
  }
}
