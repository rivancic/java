package com.rivancic.java.lambda;

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

  class Voucher {
    int amount;
    String name;
    State state;
  }

  class State {
    int value;
    String stateName;
  }

  Comparator<Voucher> stateComparator =
    (voucher1, voucher2) -> Integer.compare(voucher1.state.value, voucher2.state.value);

  /**
   * 
   * Stream contains method {@link Stream#sorted(Comparator)} that accepts {@link Comparator} object
   * and sorts the elements in stream using it. The {@link Stream#sorted()} without
   * {@link Comparator} interface as a parameter sorts elements in a natural order.
   */
  @Test
  public void sortedMetodTest() throws Exception {

    State pending = new State();
    pending.value = 1;
    pending.stateName = "PENDING";
    State active = new State();
    active.value = 0;
    active.stateName = "ACTIVE";
    State expired = new State();
    expired.value = 2;
    expired.stateName = "EXPIRED";

    Voucher voucher1 = new Voucher();
    voucher1.amount = 10;
    voucher1.name = "Spring Action";
    voucher1.state = pending;
    Voucher voucher2 = new Voucher();
    voucher2.amount = 8;
    voucher2.name = "Autumn Action";
    voucher2.state = active;
    Voucher voucher3 = new Voucher();
    voucher3.amount = 15;
    voucher3.name = "BlackFriday";
    voucher3.state = pending;
    Voucher voucher4 = new Voucher();
    voucher4.amount = 20;
    voucher4.name = "Birthday Voucher";
    voucher4.state = expired;

    Stream.of(voucher1, voucher2, voucher3, voucher4).sorted(stateComparator)
      .forEach(voucher -> System.out.println(
        "Voucher: " + voucher.name + "[" + voucher.amount + " EUR, " + voucher.state.stateName
          + "]"));
  }
}
