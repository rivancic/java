package com.rivancic.java.basic;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SwitchStatement {

  @Test
  public void switchCaseWithDefaultFirst() throws Exception {
    String fruit = "mango";
    switch (fruit) {
      default:
        System.out.println("ANY FRUIT WILL DO");
      case "Apple":
        System.out.println("APPLE");
      case "Mango":
        System.out.println("MANGO");
      case "Banana":
        System.out.println("BANANA");
        break;
    }
  }

  @Test
  public void switchStatementWithDefaultFirst2() throws Exception {
    int score = 60;
    switch (score) {
      default:
        System.out.println("Not a valid score");

        // Following cases will not compile because the expression in case statement evaluate
        /*
         * case score < 70: System.out.println("Failed"); break; case score >= 70:
         * System.out.println("Passed"); break;
         */
    }
  }

  /**
   * In switch statement only convertible int, String and ENUM values are enabled. Not even boolean!
   * 
   * Valid variable types are:
   * <ul>
   * <li>char</li>
   * <li>byte</li>
   * <li>int</li>
   * <li>short</li>
   * <li>Wrapper classes of byte, char, int</li>
   * <li>String</li>
   * <li>Enums</li>
   * </ul>
   * 
   * Invalid variable types are:
   * <ul>
   * <li>long</li>
   * <li>float</li>
   * <li>double</li>
   * <li>Any other object</li>
   * <li>boolean</li>
   * </ul>
   * 
   * @throws Exception
   */
  @Test
  public void intSwitchStatement() throws Exception {
    char var = 10;
    String result = "";
    switch (var) {
      case 10:
        result = "TEN";
        break;
      default:
        result = "DEFAULT";
    }

    assertEquals("TEN", result);
  }


  @Test
  public void weirdOrder() throws Exception {
    int x = 2;
    switch (x) {
      default:
        System.out.println("Still no idea what x is");
      case 1:
        System.out.println("x is equal to 1");
        break;
      case 2:
        System.out.println("x is equal to 2");
        break;
      case 3:
        System.out.println("x is equal to 3");
        break;
    }
  }

  /**
   * First interesting fact is that the String instance can be constructed from the array of chars.
   * String is a valid type that can be passed in the switch case among the numerical and enum
   * values.
   * 
   * Following is from oracle java 7 documentation
   * 
   * <pre>
   * The switch statement compares the String object in its expression with the expressions associated with each case label as if it were using the String.equals method; 
   * consequently, the comparison of String objects in switch statements is case sensitive. 
   * The Java compiler generates generally more efficient bytecode from switch statements that use String objects than from chained if-then-else statements.
   * </pre>
   * 
   * Explanation of the switch case evaluation. "Mango" String equals to "Mango" String in switch
   * case so "MANGO" is printed out. Because this switch case is missing break keyword the execution
   * will continue to the next case statement. This one will print out "BANANA".
   * 
   * The end result is:
   * 
   * <pre>
   * "MAMNGO"
   * "BANANA"
   * </pre>
   * 
   * @throws Exception
   */
  @Test
  public void switchMixedWithString() throws Exception {
    String fruit = new String(new char[] {'M', 'a', 'n', 'g', 'o'});
    switch (fruit) {
      default:
        System.out.println("ANY FRUIT WILL DO");
      case "Apple":
        System.out.println("APPLE");
      case "Mango":
        System.out.println("MANGO");
      case "Banana":
        System.out.println("BANANA");
        break;
    }
  }

  /**
   * Be cautious. Char value '7' is stored as int 55. The case statement could also be case 55:
   * 
   * @throws Exception
   */
  @Test
  public void testIntCharSwitch() throws Exception {
    int var = '7';
    switch (var) {
      case '7':
        System.out.println("Lucky no. 7");
        break;
      default:
        System.out.println("DEFAULT");
    }
  }
}
