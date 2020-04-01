package com.rivancic.java.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import org.junit.Test;

class Rope {
  int length;
  String color;

  Rope(int length, String color) {
    this.length = length;
    this.color = color;
  }

  public String toString() {
    return "Rope [" + color + ", " + length + "]";
  }

  static class RedRopeFilter {
    boolean filter(Rope rope) {
      return rope.color.equalsIgnoreCase("Red");
    }
  }
}

/**
 * RedRopeFilter#filter method is accessed by its instance because filter() method is not static one and it needs
 * an instance upon which it is invoked. Class itself is static for this reason we do not need to
 * create first Rope instance and then RedRopeFilterInstance.
 *
 * Link in java https://docs.oracle.com/javase/tutorial/java/javaOO/methodreferences.html
 */
public class MethodReferenceTest {
  public static void main(String[] args) {
    List<Rope> list = new ArrayList<>();
    list.add(new Rope(5, "red"));
    list.add(new Rope(10, "Red"));
    list.add(new Rope(7, "RED"));
    list.add(new Rope(10, "green"));
    list.add(new Rope(7, "Blue"));

    list.stream().filter(new Rope.RedRopeFilter()::filter).forEach(System.out::println); //Line n1
  }

  @Test
  public void testPredicateAndFunction() {
    BiPredicate<String, String> predicate = String::contains;
    BiFunction<String, String, Boolean> func = (str1, str2) -> {
      return predicate.test(str1, str2) ? true : false;
    };

    System.out.println(func.apply("Tomato", "at"));
  }
}
