package com.rivancic.java.basic.switchstatement;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import java.util.stream.Collectors;
import org.junit.Test;

public class SwitchStatementCharInt {

  /**
   * In switch statement only convertible int, String and ENUM values are enabled. Not even
   * boolean!
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


  /**
   * Be cautious. Char value '7' is stored as int 55. The case statement could also be case 55:
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

  /**
   * When chars are converted to ints widening is being applied
   *
   * https://www.decodejava.com/widening-and-narrowing-in-java.htm
   *
   * Every char is being converted to a numerical value. Then in the switch statement the same
   * process takes place when the chars in case statements are widened to int values for a
   * comparison.
   *
   * Integer values of characters match and NEWS is passing filter.
   */
  @Test
  public void testIntCharSwitchExample2() {
    String str = "North East West South";
    String result = str.chars().filter(SwitchStatementCharInt::isDirection)
      .mapToObj(c -> String.valueOf((char) c)).collect(Collectors.joining());
    assertThat(result).isEqualTo("NEWS");
  }


  private static boolean isDirection(int ch) {
    switch (ch) {
      case 'N':
      case 'E':
      case 'W':
      case 'S':
        return true;
    }
    return false;
  }

}
