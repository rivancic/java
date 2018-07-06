package com.rivancic.java.basic;

import org.junit.Test;

public class WhileLoop {

  /**
   * While loop is missing brackets. This means that only first and single row will be executed
   * inside while loop. Because after execution will be done value of x variable will not be changed
   * so the loop will execute again and again... It will be stuck in infinite loop and expression
   * increment will never be executed.
   * 
   * @throws Exception
   */
  @Test(timeout = 3000)
  public void whileLoopBrackets() throws Exception {
    int x = 5;
    while (x < 10)
      System.out.println(x);
    x++;
  }

  /**
   * Compiler predicts that the block of code inside the while statement is unreachable and throws
   * compilation error. If the variable is not marked as final it can not predict that the codeblock
   * would not be reachable.
   * 
   * <p>
   * Result of original code is compilation error.
   * </p>
   * 
   * @throws Exception
   */
  @Test
  public void nothingHappens() throws Exception {
    final boolean flag = false;
    // while (flag) {
    // System.out.println("Good Morning!");
    // }
  }
}
