package com.rivancic.java.basic.staticblocks;

/**
 * Static blocks are following each other in sequential fashion
 *
 * Result will be 9999
 */
public class StaticBlockTest {
  static int a = 10000; // this is initialized first

  static { // static block will be executed when the class will be loaded
    --a; // then its decreased
  }

  { // this is instance initialization block, will not be executed in below main method
    ++a; // then its increased
  }

  public static void main(String[] args) {
    System.out.println(a);
  }
}