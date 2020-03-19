package com.rivancic.java.basic;

import com.rivancic.java.basic.EnumSwitch.TrafficLight;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;
import org.junit.Test;

/**
 * Inner class can not have static declarations at all.
 * No static variables, no static initializers, no static methods
 *
 * But one can still use instance initializer or constructor to execute part of code.
 *
 * As a result test will print HELLO but not from OuterClass#sayHello() method
 */
public class InnerInitializerTest {

  @Test
  public void innerInitializerTest() {
    OuterClass.sayHello();
  }

  @Test
  public void main() {
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


class OuterClass {
  public static void sayHello() {

  }
  static {
    class Inner {
      Inner(){
        System.out.println("HELLO");
      }

      // or

      // {
      // System.out.println("HELLO");
      //}
    }


    new Inner();
  }
}

