package com.rivancic.java.genericscollections;


class Printer1<String> {
  private String t;

  Printer1(String t){
    this.t = t;
  }

  /* String is placeholder for generic type for this reason overriden toString method throws
     compilation error as its not compatible with java String type
    public String toString() {
    return null;
  }
   */

}

public class GenericClassDefinitionTest {
  public static void main(String[] args) {
    Printer1<Integer> obj = new Printer1<>(100);
    System.out.println(obj);
  }
}