package com.rivancic.java.genericscollections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class CollectionSortTest {

  @Test
  public void collectionsSortMethod() {
    List<String> list = Arrays.asList("M", "R", "A", "P");

    // If comparator parameter is passed in as null then the natural sorting wil be applied.
    // This method is actually the same as Collections#sort(List list)
    Collections.sort(list, null);

    System.out.println(list);
    Assert.assertEquals(Arrays.asList("A", "M", "P", "R"), list);
  }
}
