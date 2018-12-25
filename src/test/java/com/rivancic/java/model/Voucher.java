package com.rivancic.java.model;

import java.util.Comparator;

public class Voucher {
  public int amount;
  public String name;
  public State state;

  public static Comparator<Voucher> stateComparator =
    (voucher1, voucher2) -> Integer.compare(voucher1.state.value, voucher2.state.value);
}
