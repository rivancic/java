package com.rivancic.java.io;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import org.junit.Test;

public class StreamClosingTest {

  /**
   * If exception is thrown resources will not be closed correctly. Use try-with block instead.
   * If close is called on BufferedOutputStream then the underlying stream will be cloded as well.
   * @throws IOException
   */
  @Test
  public void testStreamClosing() throws IOException {
    BufferedOutputStream bos = new BufferedOutputStream(
      new FileOutputStream("F:\\file.tmp"));
    bos.write(2);
    bos.close();
  }

  /**
   * If stream is being used after it is closed IOException:java.io.IOException: Stream closed will be thrown
   */
  @Test
  public void useStreamAfterClosingTest() {
    try(BufferedWriter bw = new BufferedWriter(new FileWriter("F:\\test.txt")))
    {
      bw.close();
      bw.newLine();
    } catch(IOException e) {
      System.out.println("IOException:" + e);
    }
  }
}
