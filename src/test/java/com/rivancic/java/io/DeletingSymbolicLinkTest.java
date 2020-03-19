package com.rivancic.java.io;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.Test;

public class DeletingSymbolicLinkTest {

  /**
   * First create a file
   *
   * In case the file is symbolic link only symbolic link will be removed. The original file will
   * still stay.
   */
  @Test
  public void deleteExistingSymbolicLinkTest() throws IOException {

    // given
    String homeDir = System.getProperty("user.home");
    Path symbolicLink = Paths.get(System.getProperty("user.home"), "tmp", "te");
    Path originalFile = Paths.get(homeDir, "tmp", "test");
    Files.write(originalFile, new byte[]{});
    if (!Files.exists(symbolicLink)) {
      Files.createSymbolicLink(symbolicLink, originalFile);
    }
    System.out.println(symbolicLink);

    // when
    Files.delete(symbolicLink);

    // then
    assertFalse(Files.exists(symbolicLink, LinkOption.NOFOLLOW_LINKS));
    assertTrue(Files.exists(originalFile, LinkOption.NOFOLLOW_LINKS));
  }
}
