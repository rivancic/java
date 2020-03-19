package com.rivancic.java.string;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class StringBuilderTest {


  @Test
  public void stringBuilderWithString() {

    // given
    String str = "java";
    StringBuilder sb = new StringBuilder("java");

    // then
    Assertions.assertThat(str.equals(sb)).isEqualTo(false);
    Assertions.assertThat(sb.equals(str)).isEqualTo(false);
  }


  /**
   * The = = operator compares references not values of Stirng type.
   * 
   * @throws Exception
   */
  @Test
  public void stringTypeOperatorComparison() throws Exception {

    // given
    StringBuilder sb = new StringBuilder("Java");
    String s1 = sb.toString();
    String s2 = sb.toString();

    // then
    Assertions.assertThat(s1 == s2).isEqualTo(false);
  }


  @Test
  public void stringBuilderReverseFunction() throws Exception {

    // given
    String result = new StringBuilder("Java").reverse().append(" Ola").reverse().toString();

    // then
    Assertions.assertThat(result).isEqualTo("alO Java");
  }
}
