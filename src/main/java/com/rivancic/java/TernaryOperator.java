package com.rivancic.java;

/**
 * <h1>Question</h1>
 * <p>
 * What will be the result of compiling and executing Test class using below commands?<br>
 * javac FirstArg.java<br>
 * java FirstArg First Second
 * </p>
 * 
 * <h1>Answer</h2>
 * <p>
 * The output will be First because the expression in ternary operand will evaluate to true and so
 * the first argument will be printed
 * </p>
 *
 */
public class TernaryOperator {
  private static boolean flag = !true;

  public static void main(String[] args) {
    System.out.println(!flag ? args[0] : args[1]);
  }


}
