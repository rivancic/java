package com.rivancic.java.stream;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;


interface StringConsumer extends Consumer<String> {
  @Override
  default void accept(String s) {
    System.out.println(s.toUpperCase());
  }
}

class MyException extends RuntimeException {}

class YourException extends RuntimeException {}

enum Flags {
  TRUE, FALSE;

  /*Flags() {
    System.out.println("HELLO");
  }*/
}

public class FunctionalInterfaceOverride {







    public static void main(String[] args) {
      //Flags flags = new Flags();

  }
}
