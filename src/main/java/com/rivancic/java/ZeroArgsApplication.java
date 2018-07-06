package com.rivancic.java;

/**
 * <p>
 * Invocation of main class is specified in The java Language Specification, 12.1:
 * 
 * "The Java Virtual Machine starts execution by invoking the method main of some specified class,
 * passing it a single argument, which is an array of strings"
 * </p>
 * 
 * If the application is invoked with<br>
 * java ZeroArgsApplication, so no parameters are passed in then the args array is empty but not
 * null.
 * 
 * A bit about arguments you can find at
 * <a href="https://docs.oracle.com/javase/tutorial/essential/environment/cmdLineArgs.html"> Java
 * Tutorials</a>
 * 
 */
public class ZeroArgsApplication {

  public static void main(String[] args) {
    System.out.println(args.length);
  }
}
