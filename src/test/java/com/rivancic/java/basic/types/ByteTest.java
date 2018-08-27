package com.rivancic.java.basic.types;

import org.junit.Test;

public class ByteTest {
  @Test
  public void byteTest() throws Exception {
    byte var = 100;
    switch (var) {
      case 100:
        System.out.println("var is 100");
        break;
      // Does not compile because we can store only 127 as Max size
      /*
       * case 200: System.out.println("var is 200"); break;
       */
      default:
        System.out.println("In default");
    }
  }

  /**
   * The result will be -108. Explanation. Bytes have value from -128 to 127. After 127 adding one
   * adds significant bit which means negative value for the byte variable.
   * 
   * @throws Exception
   */
  @Test
  public void intToByte() throws Exception {
    byte b1 = (byte) (127 + 21);
    System.out.println(b1);
  }
}
