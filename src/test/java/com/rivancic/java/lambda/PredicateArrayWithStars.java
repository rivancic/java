package com.rivancic.java.lambda;

import java.util.function.Predicate;
import org.junit.Test;

public class PredicateArrayWithStars {
  @Test
  public void whatWillBePrinted() throws Exception {
    String[] arr = {"*", "**", "***", "****", "*****"};

    // Without generic type specified for the predicate the expression on the right side can not
    // know that s variable is string and that length() method can be used. By default s is of
    // Object type
    // Without commented out line program will throw compilation error.
    // Predicate pr1 = s -> s.length() < 4;

    Predicate<String> pr1 = s -> s.length() < 4;
    print(arr, pr1);
  }

  private static void print(String[] arr, Predicate<String> predicate) {
    for (String str : arr) {
      if (predicate.test(str)) {
        System.out.println(str);
      }
    }
  }
}
