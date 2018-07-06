package com.rivancic.java.basic;

import org.junit.Test;

public class VariablesAsignment {

  String s;

  /**
   * Be cautious about direct assignment of variables with different types. They hold different
   * amount of information and if we want to assign variable with more information than the target
   * variable type can hold we will get compilation error.
   * 
   * If the variable is being explicitly downcasted before then the compiler will not complain.
   * 
   * There are two errors in code below. decimal to float, and float to integer.
   * 
   * Notice that we can write integer values with underscore like that int i = 10_0; It helps at
   * readability.
   * 
   * Check data type <a href="https://wpollock.com/Java/TypeChart.htm"> memory sizes</a>
   * 
   * 
   * @throws Exception
   */
  @Test
  public void primitiveTypeVariableAssignment() throws Exception {
    long l = 100_00l;
    int i = 100;
    float f = 2.02f;
    double d = 10_0.35d;
    f = l;
    d = l;
    // f = d; // Decimal can not be put into float variable because its bigger and it would loose
    // the information. It would be possible if we would explicitly cast it like f = (float) d;
    d = f;
    f = i;
    // i = f; // The same holds here, float can not be saved in integer variable directly because it
    // would loose the information. Anyway it is possible to force it with explicit casting.
    i = (int) d;
  }

  /**
   * If the local variable is declared but not initialized through the program flow compiler throws
   * exception. The local variable color may not have been initialized.
   * 
   * This is one of the differences between method local and member variables.
   * 
   * Member variables are being initialized with default values.
   * 
   * @throws Exception
   */
  @Test
  public void missedInitialization() throws Exception {
    float area = 5;
    String color = "no color";

    // Can't use statement without initialization of the variable.
    // String color;
    if (area < 7)
      color = "green";
    System.out.println(color);
    System.out.println(s);
  }
}
