package com.rivancic.java.genericscollections.list;

import java.util.ArrayList;
import org.junit.Test;

/**
 * ArrayList native method clone returns copy with references for values read the comment.<br>
 * Returns a shallow copy of this ArrayList instance. (The elements themselves are not copied.)<br>
 * Source: <a href=
 * "http://grepcode.com/file/repository.grepcode.com/java/root/jdk/openjdk/6-b14/java/util/ArrayList.java#ArrayList.clone%28%29">grepcode</a>
 *
 */
public class ArrayListClone {
  class Counter {
    int count;

    Counter(int count) {
      this.count = count;
    }

    public String toString() {
      return "Counter-" + count;
    }
  }

  @Test
  public void cloneArrayList() {
    ArrayList<Counter> original = new ArrayList<>();
    original.add(new Counter(10));
    ArrayList<Counter> cloned = (ArrayList<Counter>) original.clone();
    cloned.get(0).count = 5;

    // If you expect it will print out [Counter-10] you are wrong.
    // The counter item in cloned list is the same reference to the counter in the original list.
    System.out.println(original);
  }
}
