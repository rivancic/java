package com.rivancic.java.genericscollections.map;

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
  
  /**
   * Map interface now contains {@link Map#merge(Object, Object, java.util.function.BiFunction)}
   * function that modifies an value of a key. It can be used for example for the word count.
   * 
   * 1. If key does not exists yet add it to the map
   * 2. If value is null replace it with the new value
   * 3. If value is not null apply BiFunction on new (first parameter) and old (second parameter) value
   */
  @Test
  public void mergeFunctionWithMap() throws Exception {
    Map<Character, Integer> charCount = new HashMap<>();
    String text =
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
    
    text.chars().forEach(i -> {
      charCount.merge((char)i, 1, Integer::sum);
      
    });
    System.out.println(charCount);
    
  }
}
