package com.rivancic.java;

/**
 * Static block gets executed first. And because it contains runtime error main method will not be
 * executed. It will throw {@link java.lang.ArithmeticException}
 * 
 * @author Renato Ivancic <r.ivancic@dodax.com>
 *
 */
public class StaticExceptionApplication {

  static {
    System.out.println(1 / 0);
    // System.out.println("HELLO AAA");
  }

  public static void main(String[] args) {
    System.out.println("HELLO");
  }
}
