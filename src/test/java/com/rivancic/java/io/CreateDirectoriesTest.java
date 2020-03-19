package com.rivancic.java.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import org.junit.Test;

public class CreateDirectoriesTest {

  @Test
  public void main() throws IOException {
    Path path = Paths.get("/home/rivancic/X/Y/Z");
    Files.createDirectories(path);


  }
}


