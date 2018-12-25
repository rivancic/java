package com.rivancic.java.genericscollections.comparison;

/**
 * Class that represents a voucher. The voucher can have a name and a status. Status can be active
 * or inactive (true/false).
 * 
 * @author rivancic
 *
 */
public class Voucher implements Comparable<Voucher> {
  private boolean status = false;
  private String name;

  public Voucher(String name, boolean status) {
    this.status = status;
    this.name = name;
  }

  /**
   * Vouchers are naturally sorted based on the status. Ordered first are vouchers with active status
   * following by the vouchers with the inactive status.
   */
  @Override
  public int compareTo(Voucher voucher) {
    int result = 0;

    if (status && !voucher.status) {
      result = -1;
    } else if (!status && voucher.status) {
      result = 1;
    }
    return result;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return "Voucher [status=" + status + ", name=" + name + "]";
  }
}
