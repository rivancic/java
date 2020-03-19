package com.rivancic.java.files;

import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.Test;

public class PathTest {

  /**
   * Path has 4 parts.
   * It will print 4
   * directory is c
   * and name on the second place is b
   */
  @Test
  public void pathTest() {
    Path path = Paths.get("/etc/a/b/c/");
    System.out.printf("%d, %s, %s", path.getNameCount(), path.getFileName(), path.getName(2));
  }
}
