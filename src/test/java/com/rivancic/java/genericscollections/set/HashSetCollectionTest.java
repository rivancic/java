package com.rivancic.java.genericscollections.set;

import java.util.HashSet;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.Test;


public class HashSetCollectionTest {

  /**
   * HashSet implements methods form collection. This means we can add and remove specific objects.
   */
  @Test
  public void implementsCollectionInterfaceTest() {

    // given
    Set<String> collectionSet = new HashSet<>();

    // when
    collectionSet.add("One");
    collectionSet.add("Two");
    collectionSet.remove("Two");

    // then
    Assertions.assertThat(collectionSet).containsExactly("One");
  }
}
