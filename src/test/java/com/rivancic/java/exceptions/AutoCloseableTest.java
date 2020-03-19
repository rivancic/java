package com.rivancic.java.exceptions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import org.junit.Test;

class Resource1 implements AutoCloseable {
  public void m1() throws Exception {
    System.out.print("A");
    throw new Exception("B");
  }

  public void close() {
    System.out.print("C");
  }
}

class Resource2 implements AutoCloseable {
  public void m2() {
    System.out.print("D");
  }

  public void close() throws Exception {
    System.out.print("E");
  }
}


public class AutoCloseableTest {

  @Test
  public void autoCloseableTest() {

    try (Resource1 r1 = new Resource1();
      Resource2 r2 = new Resource2()) {
      r1.m1();
      r2.m2();
    } catch (Exception e) {
      System.out.print(e.getMessage());
    }
  }

  /**
   * After try block writer = bw will be closed.
   *
   * In finally block we try to flush closed bw Writer. This will throw IOException (Stream closed)
   * @throws IOException
   */
  @Test
  public void autocloseableResourceDeclaredOutside() throws IOException {
    BufferedWriter bw = new BufferedWriter(new FileWriter("F:\\temp.tmp"));
    try(BufferedWriter writer = bw) { //Line 8

    } finally {
      bw.flush(); //Line 11
    }
  }
}
