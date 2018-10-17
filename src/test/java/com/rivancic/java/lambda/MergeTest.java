package com.rivancic.java.lambda;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.Test;

public class MergeTest {


  /**
   * Map contains a merge function. It accepts the key, possible new value for that key if it does
   * not hold any or function that calculates new value if the key is already existing. In case that
   * the new value is null the key gets removed.
   * 
   * @throws Exception
   */
  @Test
  public void testMergeMethodOnMap() throws Exception {

    Map<String, String> temperaments = new HashMap<>();
    temperaments.put("Choleric", "Aggressive");
    temperaments.put("Sanguinic", "Talkative");
    temperaments.put("Melanhonic", "Moody");
    temperaments.put("Phlegmatic", "Passive");

    BiFunction<String, String, String> addTrace = (value, addition) -> value + " and " + addition;

    temperaments.merge("Moronic", "Crazy", addTrace);
    temperaments.merge("Phlegmatic", "Peaceful", addTrace);
    System.out.println(temperaments.toString());
  }
}
