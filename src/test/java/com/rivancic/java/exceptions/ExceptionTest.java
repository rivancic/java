package com.rivancic.java.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.junit.Test;

public class ExceptionTest {


  @Test
  public void testHandlingIOException() {

    Super s = new Sub();
    try {
      s.m1();
      // } catch (FileNotFoundException e) { // Only this catch statement Will throw exception
      // because
      // we have to catch IOException
    } catch (IOException e) {
      System.out.print("M");
    } finally {
      System.out.print("N");
    }

  }

  /**
   * Check handling of exceptions. Is super class is already handled what happens with child
   * Exception. You have to be very careful about the order of types in catch statements. Always you
   * have to order the types from bottom of the hierarchy to the top. Child classes has to be first
   * and then we catch parent classes, otherwise compilers gives an error.
   * 
   * @throws Exception
   */
  @Test
  public void childClassExceptionCatchDefinedAfterParentWillNotCompile() throws Exception {
    Super s = new Sub();
    try {
      s.m1();
    } catch (IOException ioException) {
      System.out.print("IOException");

    }
    // Would not compile, parent class is catching exception before this catch declaration.
    // catch (FileNotFoundException e) {
    // System.out.print("FileNotFoundException fileNotFoundException");
    // }
    finally {
      System.out.print("Finally");
    }

  }

  @Test
  public void testName2() throws Exception {
    double result = 10d / 0d;
    double result1 = Double.POSITIVE_INFINITY / 100000;
    System.out.println(result);

    System.out.println(result1);
  }

  abstract class Super {
    public abstract void m1() throws IOException;
  }

  class Sub extends Super {
    @Override
    public void m1() throws IOException {
      throw new FileNotFoundException();
    }
  }


  public static void main(String[] args) {
    // m1(); // Line 3 Compilation error, has to handle Checked exception that can be thrown from m1
    // method.
  }

  private static void m1() throws Exception { // Line 6
    System.out.println("NOT THROWING ANY EXCEPTION"); // Line 7
  }
}
