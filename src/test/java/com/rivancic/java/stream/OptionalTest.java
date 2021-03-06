package com.rivancic.java.stream;

import static org.junit.Assert.assertEquals;
import java.util.Optional;
import java.util.OptionalInt;
import org.junit.Test;

/**
 * Java Stream API.
 * 
 * Develop code that uses the Optional class.
 * 
 * Optional<T> is a wrapper class in java.util that helps you work around null pointer exceptions.
 * The Optional<T> class represents a value that may be null.
 * 
 * @author Renato Ivancic <r.ivancic@dodax.com>
 *
 */
public class OptionalTest {
  boolean isItemPresent = false;

  class Item {
    String name;
  }

  /**
   * The {@link Optional#ifPresent(java.util.function.Consumer)} will execute the consumer function
   * only in the case that the value in the Optional is present. In the case below the consumer will
   * not be invoked. For this reason the isItemPresent filed will contain te value false.
   */
  @Test
  public void filterTestWithList() {

    // given
    Optional<Item> optionalItem = Optional.empty();

    optionalItem.ifPresent(item -> {
      isItemPresent = true;
    });

    // when
    assertEquals(false, isItemPresent);

    // then
  }

  /**
   * Supplier has to be provided, In this case method reference is passed as parameter. One could
   * not be able to pass just a new instance of the exception itself
   */
  @Test
  public void optionalOrThrowTest() {
    OptionalInt optionalInt = OptionalInt.empty();
    optionalInt.orElseThrow(MyException::new);
  }
}
