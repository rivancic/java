package com.rivancic.java.files;

import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.Test;

public class FilesTest {


  /**
   * {@link Files#readAllLines(java.nio.file.Path)} method returns a List of Strings. On it we can
   * call first stream or directly to the list where Consumer action will be applied upon every
   * element. forEach. {@link Files#lines(java.nio.file.Path)} method already returns stream. The
   * only available method is then forEach. stream() method is not available on Stream itself
   * 
   * @throws Exception
   */
  @Test
  public void test1() throws Exception {
    System.out.println("readAllLines foreach");
    Files.readAllLines(Paths.get("/home/rivancic/20180615")).forEach(System.out::println);
    System.out.println("readAllLines stream foreach");
    Files.readAllLines(Paths.get("/home/rivancic/20180615")).stream().forEach(System.out::println);
    System.out.println("Lines foreach");
    Files.lines(Paths.get("/home/rivancic/20180615")).forEach(System.out::println);
  }
}
