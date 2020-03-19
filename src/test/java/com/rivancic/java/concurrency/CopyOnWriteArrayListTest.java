package com.rivancic.java.concurrency;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.junit.Test;


public class CopyOnWriteArrayListTest {

  /**
   * If CopyOnWriteArrayList is used in iteration elements can be removed form it.
   * After the iteration in first list there will still be Melon and Mango but
   * in the second list those elements will be removed.
   */
  @Test
  public void copyOnWriteArrayListTest() {
    List<String> list1 = new ArrayList<>();
    list1.add("Melon");
    list1.add("Apple");
    list1.add("Banana");
    list1.add("Mango");
    List<String> list2 = new CopyOnWriteArrayList<>(list1);
    for(String s : list2) {
      if(s.startsWith("M")){
        list2.remove(s);
      }
    }
    System.out.println(list1);
    System.out.println(list2);
  }


  /**
   * With {@link CopyOnWriteArrayList} we can iterate all of the elements in a copied list for the iteration.
   * This means all of the fruits will be printed during the iteration.
   * After for loop is over the original list will be without the elements that starts with M letter.
   */
  @Test
  public void copyOnWriteArrayListRemoveTest() {

    // given
    List<String> list = new CopyOnWriteArrayList<>();
    list.add("Melon");
    list.add("Apple");
    list.add("Banana");
    list.add("Mango");

    // when
    for(String s : list) {
      list.removeIf(str -> str.startsWith("M"));
      System.out.println(s);
    }

    // then
    System.out.println(list);
    assertEquals(Arrays.asList("Apple", "Banana"), list);
  }


}

