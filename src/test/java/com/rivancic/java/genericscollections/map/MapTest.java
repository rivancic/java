package com.rivancic.java.genericscollections.map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.junit.Test;

public class MapTest {

  enum TrafficLight {
    GREEN, RED, YELLOW;
  }

  /**
   * It is totally correct to store different types of objects as keys and as values in a raw {@link
   * HashMap}. Just be aware that the Map doesn't contain the contains() method but instead you have
   * to use specific method for checking the keys or values. The methods are {@link
   * Map#containsKey(Object)} and {@link Map#containsValue(Object)}.
   */
  @Test
  public void rawHashMapTest() {
    HashMap rawHashMap = new HashMap<>();
    rawHashMap.put("key", "keyValue");
    rawHashMap.put(1, 2);
    assertThat(rawHashMap.containsKey(1), is(true));
    assertThat(rawHashMap.containsKey("key"), is(true));
    assertThat(rawHashMap.containsValue(2), is(true));
    assertThat(rawHashMap.containsValue("keyValue"), is(true));
  }

  @Test
  public void mapMethodsTest() {
    TreeMap<String, Integer> treeMap = new TreeMap<>();
    treeMap.put("77", 77);
    treeMap.put("seven", 7);
    treeMap.put("SEven", 7);
    assertThat(treeMap.firstKey(), is("77"));
    assertThat(treeMap.lastKey(), is("seven"));
    assertThat(treeMap.firstEntry().getValue(), is(77));
  }

  /**
   * Map#values() returns collection that we can print out
   */
  @Test
  public void mapValuesTest() {
    Map<TrafficLight, String> map = new TreeMap<>();
    map.put(TrafficLight.GREEN, "GO");
    map.put(TrafficLight.RED, "STOP");
    map.put(TrafficLight.YELLOW, "READY TO STOP");
    for (String msg : map.values()) {
      System.out.println(msg);
    }
  }
}
