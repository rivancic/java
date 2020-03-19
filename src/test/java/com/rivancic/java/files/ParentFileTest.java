package com.rivancic.java.files;

import java.io.File;
import org.junit.Test;

public class ParentFileTest {

  /**
   * File#getParentFile() returns parent File object. File#getParent() returns parent directory name as String.
   * If getParentFile on root is called null is being returned.
   */
  @Test
  public void parentFileTest() {
    File dir = new File("F:" + File.separator + "A" + File.separator + "B");
    System.out.println(dir.getParentFile().getParent());
  }
}
