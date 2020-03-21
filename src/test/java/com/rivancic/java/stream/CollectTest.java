package com.rivancic.java.stream;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;

/**
 * Stream methods to collect the elements. They are used at the final step of processing a Stream.
 * Its a terminal method. It allows to perform mutable fold operations (repackaging elements to some
 * data structures and applying some additional logic, concatenating them, etc.) on data elements
 * held in a Stream instance.
 * 
 * The strategy for this operation is provided via Collector interface implementation.
 * 
 * All predefined implementations can be found in the Collectors class.
 * 
 * Source: https://www.baeldung.com/java-8-collectors
 * 
 * @author rivancic
 *
 */
public class CollectTest {


  /**
   * {@link Collectors#toList()} collector can't guarantee which type of List will be returned.
   * 
   * @throws Exception
   */
  @Test
  public void collectorsToListTest() throws Exception {
    List<String> someList = Streams.getLanguagesStream().collect(Collectors.toList());

    // We know that the result is of type List but we can not assume of which concrete type.
    assertThat(someList, instanceOf(List.class));
  }

  /**
   * If you want to explicitly specify which type of the list you want to have as a result you have
   * to use toCollection method providing the specific constructor/supplier.
   * 
   * @throws Exception
   */
  @Test
  public void collectorsToCollectionTest() throws Exception {
    List<String> arrayList =
      Streams.getLanguagesStream().collect(Collectors.toCollection(() -> new ArrayList<>()));

    // or with method reference

    arrayList = Streams.getLanguagesStream().collect(Collectors.toCollection(ArrayList::new));

    // Because we provided the exact supplier we know that the collection is of concrete type
    // ArrayList.
    assertThat(arrayList, instanceOf(ArrayList.class));
  }

}
