package com.rivancic.java;

public class LoopApplicationInitialization {

  public static void main(String[] args) {
    try {
      main(args);
    } catch (Error ex) {
      System.out.println("CATCH-");
    }
    System.out.println("OUT");
  }
}
