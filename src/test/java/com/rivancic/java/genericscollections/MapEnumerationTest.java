package com.rivancic.java.genericscollections;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;
import org.junit.Test;

/**
 * TreeMap sorts enumeration keys by the order they are declared.
 * Enum implements comparable that compares its elements by ordinal number.
 */
public class MapEnumerationTest {

  enum TrafficLight {
    RED, YELLOW, GREEN
  }

  @Test
  public void main() throws IOException {
    Map<TrafficLight, String> map = new TreeMap<>();
    map.put(TrafficLight.GREEN, "GO");
    map.put(TrafficLight.RED, "STOP");
    map.put(TrafficLight.YELLOW, "STOP IN 3 Seconds");
    map.put(TrafficLight.YELLOW, "READY TO STOP");

    for(String msg : map.values()) {
      System.out.println(msg);
    }
  }
}
