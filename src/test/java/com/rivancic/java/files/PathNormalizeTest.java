package com.rivancic.java.files;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class PathNormalizeTest {

  /**
   * Path#normalize method is not checking if the file really exist.
   *
   * It is deduplicating the path removing any parent path symbols..
   */
  @Test
  public void normalizeTest() {
    // given
    Path path = Paths.get("F:", "user", "..", "udayan..");

    // when
    Path normalizedPath = path.normalize();

    // then
    Assertions.assertThat(normalizedPath).isEqualTo(Paths.get("F:/udayan.."));
  }


  class Message {

    public void printMessage() {
      System.out.println("Hello!");
    }
  }

  @Test
  public void testMessage() {

    Stream<String> stream = Arrays.asList("One", "Two", "Three").stream();
    System.out.println(stream.reduce(null, (s1, s2) -> s1 + s2));

    Message msg = new Message() {
      @Override
      public void printMessage() {
        System.out.println("HELLO!");
      }
    };
    msg.printMessage();
  }


  @Test
  public void test1() {


  }

}