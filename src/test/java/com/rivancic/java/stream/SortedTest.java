package com.rivancic.java.stream;

import com.rivancic.java.model.Voucher;
import java.util.Comparator;
import java.util.stream.Stream;
import org.junit.Test;

/**
 * <p>
 * Java Stream API
 * </p>
 * <p>
 * Sort a collection using Stream API
 * </p>
 * 
 * @author Renato Ivancic <r.ivancic@dodax.com>
 *
 */
public class SortedTest {

  /**
   * 
   * Stream contains method {@link Stream#sorted(Comparator)} that accepts {@link Comparator} object
   * and sorts the elements in stream using it. The {@link Stream#sorted()} without
   * {@link Comparator} interface as a parameter sorts elements in a natural order.
   */
  @Test
  public void sortedMetodTest() throws Exception {

    Streams.getVoucherStream().sorted(Voucher.stateComparator)
      .forEach(voucher -> System.out.println(
        "Voucher: " + voucher.name + "[" + voucher.amount + " EUR, " + voucher.state.stateName
          + "]"));
  }
}
