package com.rivancic.java.basic;

import org.junit.Test;

public class IfElseTest {


  /**
   * Will throw compilation error that model might not have been initialized.
   */
  @Test
  public void typeComparison() {
    double price = 90000;
    String model;
    if (price > 100000) {
      model = "Tesla Model X";
    } else if (price < 100000) {
      model = "Tesla Model S";
    }
    // System.out.println(model);
  }

  /**
   * If, if else statement is written without brackets then the if statement can contain only one
   * statement. In below example there are 2 statements inside the if statement so the compiler
   * throws an error. This is the reason the line is commented out.
   * 
   * @throws Exception
   */
  @Test
  public void ifElseWithoutBrackets() throws Exception {
    int grade = 75;
    if (grade > 60)
      System.out.println("Congratulations");
    // System.out.println("You passed");
    else
      System.out.println("You failed");
  }
}
