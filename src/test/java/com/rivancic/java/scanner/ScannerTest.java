package com.rivancic.java.scanner;

import static org.junit.Assert.assertEquals;
import java.util.Scanner;
import org.junit.Test;

/**
 * A simple text scanner which can parse primitive types and strings using regular expressions.
 *
 * 
 * A <code>Scanner</code> breaks its input into tokens using a delimiter pattern, which by default
 * matches whitespace.
 * 
 *
 */
public class ScannerTest {

  /**
   * Scanner findInLine accepts a regular expression and then returns the first match found in the
   * whole line. Find line is ignoring delimiters.
   */
  @Test
  public void scannerFindInLineTest() {
    try (Scanner scanner = new Scanner("a10b20c30b22\na40b50c60")) {

      // Regular expression matches the literal b followed by one or more numeric values
      String bInFirstLine = scanner.findInLine("b\\d+");
      scanner.nextLine();

      // Regular expression matches the literal c followed by one or more numeric values
      String cInSecondLine = scanner.findInLine("c\\d+");
      assertEquals("b20", bInFirstLine);
      assertEquals("c60", cInSecondLine);
    }
  }

  /**
   * Scanner useDelimiter can set other delimiter than default whitespace. In next example delimiter
   * is set to ", " which is a common format for enumeration.
   */
  @Test
  public void scannerDelimiterTest() {
    try (Scanner scanner = new Scanner("a10, b20, c30, a40, b50, c60")) {
      scanner.useDelimiter(",\\s+");
      String firstToken = scanner.next();
      String secondToken = scanner.next();
      String thirdToken = scanner.next();

      assertEquals("a10", firstToken);
      assertEquals("b20", secondToken);
      assertEquals("c30", thirdToken);
    }
  }
}
