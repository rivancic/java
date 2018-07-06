package com.rivancic.java.string;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class StringTest {

  @Test
  public void stringAssignment() throws Exception {
    String str1 = new String("Core");
    String str2 = new String("CoRe");
    System.out.println(str1 = str2);
  }


  /**
   * An example of swift code: ICICINBBRT4<br>
   * ICIC: First 4 letters for bank code<br>
   * IN: Next 2 letters for Country code<br>
   * BB: Next 2 letters for Location code<br>
   * RT4: Next 3 letters for Branch code<br>
   * 
   * @throws Exception
   */
  @Test
  public void substring() throws Exception {
    System.out.println("ICICINBBRT4".substring(4, 6));
  }

  @Test
  public void stringConcatenation() throws Exception {
    String concatenatedString = "Output is: " + (10 != 5);
    System.out.println(concatenatedString);
    assertEquals("Output is: true", concatenatedString);
  }


  /**
   * String is immutable. This means trim() method will not change the instance of str1. It will
   * just return modified text value. So reusing str1 and checking if its empty will yield the same
   * result as the first time. False because it has the length of 1. Ans {@link String#isEmpty()}
   * returns true if length is 0.
   * 
   * @throws Exception
   */
  @Test
  public void emptyStringTest() throws Exception {
    String str1 = " ";
    boolean b1 = str1.isEmpty();
    System.out.println(b1);
    str1.trim();
    boolean b2 = str1.isEmpty();
    System.out.println(b1);
    assertEquals(false, b1);
    assertEquals(false, b2); // Because str1 did not change
  }

  @Test
  public void stringConcatenationWithInt() throws Exception {

    // Expression is being evaluated from left to the right. Ints are added up and then in the last
    // step the sum gets converted to string nad concatenated.
    String concatenatedStringFirstInt = 1 + 2 + 3 + 4 + "Hello";
    String concatenatedString = "Hello" + 1 + 2 + 3 + 4;
    assertEquals("Hello1234", concatenatedString);
    assertEquals("10Hello", concatenatedStringFirstInt);
  }

  /**
   * {@link String#length()} is really simple method. It returns the length which is 11. Then the
   * concatenation returns additional colon. And as the last operand in concatenation character at
   * the position 10 is returned, this turns out to be exclamation mark.
   * 
   * <The end result is 11: !
   * 
   * @throws Exception
   */
  @Test
  public void getCharAt() throws Exception {
    String str = "Java Rocks!";
    String concatenatedString = str.length() + " : " + str.charAt(10);
    System.out.println(concatenatedString);
    assertEquals("11 : !", concatenatedString);
  }
}
