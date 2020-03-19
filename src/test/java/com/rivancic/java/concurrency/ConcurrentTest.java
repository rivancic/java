package com.rivancic.java.concurrency;

import static org.junit.Assert.assertEquals;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;

public class ConcurrentTest {

  /**
   * The Stream#flatMap always returns a Stream that is not parallel.
   * The Collectors#groupingByConcurrent still works, but its not any more efficient.
   */
  @Test
  public void testConcurrentGrouping() {

    Stream<String> cats = Stream.of("leopard", "hello kitty", "pismo").parallel();
    Stream<String> bears = Stream.of("panda", "grizzly", "polar", "teddy").parallel();
    Stream<String> flatenedStream = Stream.of(cats, bears).flatMap(s -> s);
    boolean isParallel = flatenedStream.isParallel();
    ConcurrentMap<Boolean, List<String>> map = flatenedStream.collect(
    Collectors.groupingByConcurrent(s -> !s.startsWith("p")));
    assertEquals(false, isParallel);
    assertEquals(3, map.get(false).size());
    assertEquals(4, map.get(true).size());
  }
}
