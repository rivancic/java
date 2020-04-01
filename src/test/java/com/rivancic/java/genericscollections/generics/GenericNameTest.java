package com.rivancic.java.genericscollections.generics;

import java.util.LinkedList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class GenericNameTest {

  /**
   * Object{@link #getClass()} method returns the name of the runtime class of this instance.
   * It does not hold any information about the generic type as its erased at runtime.
   * It shows that generic type is not build in DNA of the language. Rather the compiled code
   * contains wrappers to handle it.
   */
  @Test
  public void genericNameTest() {

    // given
    LinkedList<String> stringList = new LinkedList<>();
    List<Long> longList= new LinkedList<>();

    // then
    Assertions.assertThat(stringList.getClass().toString()).isEqualTo("class java.util.LinkedList");
    Assertions.assertThat(longList.getClass().toString()).isEqualTo("class java.util.LinkedList");
  }
}
