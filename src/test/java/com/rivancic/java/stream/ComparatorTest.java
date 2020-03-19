package com.rivancic.java.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ComparatorTest {

  @Test
  public void testComparison() {

    String[] arr = {"**", "***", "*", "*****", "****"};
    Arrays.sort(arr, (s1, s2) -> s1.length() - s2.length());
    Assertions.assertThat(arr)
      .containsExactly("*", "**", "***", "****","*****");
  }

  /**
   * List of emails will be sorted by only looking at the domain of the email address.
   * Email usernames are not taken into consideration at sorting so thy are taken in the order they
   * are put in the emails. For example sachin / udayam are not being compared and sorted.
   */
  @Test
  public void compareEmailDomains() {
    List<String> emails = Arrays
      .asList("udayan@outlook.com", "sachin@outlook.com", "sachin@gmail.com",
        "udayan@gmail.com");
    Collections.sort(emails, Comparator.comparing(str -> str.substring(str.indexOf("@") + 1)));
    Assertions.assertThat(emails)
      .containsExactly("sachin@gmail.com", "udayan@gmail.com", "udayan@outlook.com",
        "sachin@outlook.com");
  }
}
