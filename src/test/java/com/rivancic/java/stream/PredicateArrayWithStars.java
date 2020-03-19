package com.rivancic.java.stream;

import com.sun.org.apache.bcel.internal.generic.NEW;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;
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

  @Test
  public void predicateWithCounter() {
    List<Integer> list = Arrays.asList(-80, 100, -40, 25, 200);
    Predicate<Integer> predicate = num -> {
      int ctr = 1;
      boolean result = num > 0;
      System.out.print(ctr++ + ".");
      return result;
    };

    List<Integer> list1 = Arrays.asList(10, 100, 1000);
    list1.replaceAll(i -> (-(i++)));

    System.out.println(list1);

    list.stream().filter(predicate).count();
  }


    @Test
    public void main() {
      Consumer<Integer> add = i -> Counter.count += i;
      Consumer<Integer> print = System.out::println;
      Consumer<Integer> print2 = i -> System.out.println("a" + i);
      add.andThen(print).andThen(print2).accept(11); //Line 10
    }
}

class Counter {
  static int count = 4;
}
