package com.rivancic.java.genericscollections;

class Printer<String> {
  private String t;

  Printer(String t) {
    this.t = t;
  }
}

public class SpecificGenericTest {

  public static void main(String[] args) {
    Printer<Integer> obj = new Printer<>(100);
    System.out.println(obj);

    Double d = new Double(100);
  }
}

