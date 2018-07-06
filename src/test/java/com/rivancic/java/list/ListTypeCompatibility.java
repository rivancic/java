package com.rivancic.java.list;

import java.util.List;

public class ListTypeCompatibility {

  /**
   * Which parameter will work without an error.
   * <ul>
   * <li>List<int> - Only object type can be defined as a generic type parameter.</li>
   * <li>List - {@link List#get(int)} returns Object, the unboxing will fail.</li>
   * <li>List<Object> - the unboxing will fail (Object -> Integer).</li>
   * <li>List<Integer> - Here the autounboxing will transform Integer type to primitive int.
   * (Integer -> int).</li>
   * </ul>
   * 
   * @param list
   */
  public static void process(List<Integer> list) {
    list.add(100); // Line 2
    int x = list.get(0); // Line 3
    System.out.println(list.size() + ":" + x);
  }
}
