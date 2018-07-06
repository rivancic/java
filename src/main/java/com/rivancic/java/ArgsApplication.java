package com.rivancic.java;

public class ArgsApplication {

  // Rename to main and run it as java application in order to be able to test this class
  public static void main1(String[] args) {
    Message.main(args);
  }
}


class Message {
  static void main(String[] args) {
    System.out.println("Welcome! " + args[1]);
  }
}
