package com.rivancic.java.genericscollections.map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.HashMap;
import org.junit.Test;

public class HashCodeTest {

  /**
   * Class has constant hashCode for all the instances of the class.
   */
  class WrongHashCode extends Object {
    @Override
    public int hashCode() {
      return 30;
    }
  }

  /**
   * Class has constant hashCode for all the instances of the class.
   */
  class CorrectHashCode extends Object {

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + getOuterType().hashCode();
      result = prime * result + number;
      return result;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      CorrectHashCode other = (CorrectHashCode) obj;
      if (!getOuterType().equals(other.getOuterType()))
        return false;
      if (number != other.number)
        return false;
      return true;
    }

    private int number;

    public CorrectHashCode(int number) {
      this.number = number;
    }

    private HashCodeTest getOuterType() {
      return HashCodeTest.this;
    }
  }

  /**
   * Class has constant hashCode() result, and no overriden toString method. Becuase default
   * toString implementation concatenates class name and hexadecimal hashCode representation the
   * toString method will return the same value for all instances of this class.
   * 
   * @throws Exception
   */
  @Test
  public void toStringObjectTest() throws Exception {

    // given
    WrongHashCode wrongHashCode1 = new WrongHashCode();
    WrongHashCode wrongHashCode2 = new WrongHashCode();
    WrongHashCode wrongHashCode3 = new WrongHashCode();

    // then
    assertEquals("com.rivancic.java.basic.HashCodeTest$WrongHashCode@1e",
      wrongHashCode1.toString());
    assertEquals("com.rivancic.java.basic.HashCodeTest$WrongHashCode@1e",
      wrongHashCode2.toString());
    assertEquals("com.rivancic.java.basic.HashCodeTest$WrongHashCode@1e",
      wrongHashCode3.toString());
  }



  /**
   * As the key is the same for all the key value maps. they will be overridden. Only the last
   * element put to map will be bound to wrongHashCode1 key. So the element with value
   * wrongHashCode3.
   * 
   * @throws Exception
   */
  @Test
  public void sameKeyTest() throws Exception {

    // given
    WrongHashCode wrongHashCode1 = new WrongHashCode();
    WrongHashCode wrongHashCode4 = new WrongHashCode();
    HashMap<WrongHashCode, String> hashMap = new HashMap<>();
    hashMap.put(wrongHashCode1, "1");
    hashMap.put(wrongHashCode1, "2");
    hashMap.put(wrongHashCode1, "3");

    // then
    assertEquals(false, hashMap.containsKey(wrongHashCode4));
    assertEquals(null, hashMap.get(wrongHashCode4));
    assertEquals(true, hashMap.containsKey(wrongHashCode1));
    assertEquals("3", hashMap.get(wrongHashCode1));
  }

  /**
   * As the {@link WrongHashCode} class only has constant hashCodeValue all of the key value maps
   * will be put in the same bucket. It is for this reason inefficient algorithm for retrieval of
   * the key.
   * 
   * Notice it does not really make a sense to measure with less than 15 elements in the map.
   * 
   * @throws Exception
   */
  @Test
  public void notEfficientKeys() throws Exception {

    // given
    int comparationSize = 1000;
    assertTrue(comparationSize >= 15);
    HashMap<WrongHashCode, String> inefficientHashMap = new HashMap<>();
    WrongHashCode key1 = new WrongHashCode();
    for (int i = 0; i < comparationSize; i++) {
      key1 = new WrongHashCode();
      inefficientHashMap.put(key1, i + "");
    }

    HashMap<CorrectHashCode, String> efficientHashMap = new HashMap<>();
    CorrectHashCode key2 = new CorrectHashCode(0);
    for (int i = 0; i < comparationSize; i++) {
      key2 = new CorrectHashCode(i);
      efficientHashMap.put(key2, i + "");
    }

    // when
    long start1 = System.nanoTime();
    String value1 = inefficientHashMap.get(key1);
    long time1 = System.nanoTime() - start1;

    long start2 = System.nanoTime();
    String value2 = efficientHashMap.get(key2);
    long time2 = System.nanoTime() - start2;

    System.out.println("Time1: " + time1 + " Time2: " + time2 + " Difference: "
      + (time1 - time2));

    // then
    assertEquals(true, inefficientHashMap.containsKey(key1));
    assertEquals(comparationSize - 1 + "", value1);
    assertEquals(true, inefficientHashMap.containsKey(key1));
    assertEquals(comparationSize - 1 + "", value2);
    assertTrue(time1 > time2);
  }
}
