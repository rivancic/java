package com.rivancic.java.exceptions;

import org.junit.Test;

public class CheckedExceptionTest {

  /**
   * If the Checked exception is being present in the catch statement it really has to be thrown
   * from the underlaying code. Otherwise the compilation error <b>Unreachable catch block for
   * FileNotFoundException. This exception is never thrown from the try statement body</b> will be
   * thrown.
   * 
   * <p>
   * Result is compilation error.
   * </p>
   * 
   * @throws Exception
   */
  @Test
  public void checkedException() throws Exception {
    try {
      System.out.println(1);
    } catch (NullPointerException ex) {
      System.out.println("ONE");
      // } catch (FileNotFoundException ex) {
      // System.out.println("TWO");
      // }
      System.out.println("THREE");
    }
  }
}
