package com.rivancic.java.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import org.junit.Test;

public class WriterStreamConstructor {

  @Test
  public void fileCreated() throws IOException {
    File f1 = new File("/home/rivancic/dir/f1.txt");

  }

  @Test(expected = FileNotFoundException.class)
  public void exceptionShouldBeThrownIfFileIsNotPresentFileWriter() throws IOException {
    FileWriter fw = new FileWriter("/home/rivancic/dir/f2.txt");
  }

  @Test(expected = FileNotFoundException.class)
  public void exceptionShouldBeThrownIfFileIsNotPresentPrintWriter() throws IOException {
    PrintWriter pw = new PrintWriter("/home/rivancic/dir/fsda3.tasdadxt");
  }


}
