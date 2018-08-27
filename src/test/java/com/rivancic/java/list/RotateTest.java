package com.rivancic.java.list;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

/**
 * Collections, ArrayList
 * 
 * @author Renato Ivancic <r.ivancic@dodax.com>
 *
 */
public class RotateTest {

  /**
   * An example of {@link Collections#rotate(List, int)} method.
   * 
   * @throws Exception
   */
  @Test
  public void testName() throws Exception {
    List<String> rotateList = new ArrayList<>();
    rotateList.addAll(Arrays.asList(new String[] {"A", "R", "R", "A", "Y"}));
    Collections.rotate(rotateList, 3);

    // rotated list content
    // 0 1 2 3 4
    // R A Y A R

    System.out.println(rotateList);

    assertEquals("A", rotateList.get(1));
    assertEquals("A", rotateList.remove(3));
  }
}
