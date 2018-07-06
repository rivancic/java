package com.rivancic.java.basic;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class OperatorsTest {

  @Test
  public void incrementOperator() throws Exception {
    int a = 100;
    System.out.println(-a++);
  }

  @Test
  public void plusComparisonOperator() throws Exception {
    // System.out.println("Output is: " + 10 != 5);
  }

  /**
   * Post and pre increment operators are changing value of a. But because we have short circuit OR
   * operator first one evaluates to true and second one does not get evaluated. --a is never
   * executed.
   * 
   * @throws Exception
   */
  @Test
  public void trickyResult() throws Exception {
    int a = 2;
    boolean res = false;
    res = a++ == 2 || --a == 2 && --a == 2;
    System.out.println(a);
    assertEquals(3, a);
  }

  /**
   * The expression is the same as<br>
   * (((--a * a++) + a--) - --a)
   * 
   * @throws Exception
   */
  @Test
  public void operatorsOrder() throws Exception {
    int a = 20;
    int var = --a * a++ + a-- - --a;
    System.out.println("a = " + a);
    System.out.println("var = " + var);
    assertEquals(18, a);
  }

  @Test
  public void prePostIncrementOperator() throws Exception {
    int a = 3;
    m(++a, a++);
    System.out.println(a);
  }

  private static void m(int i, int j) {
    i++;
    j--;
  }



  static class Greetings {
    String msg = null;

    public Greetings() {}

    public Greetings(String str) {
      msg = str;
    }

    public void displayMsg() {
      System.out.println(msg);
    }

    public static void main(String[] args) {
      Greetings g1 = new Greetings();
      Greetings g2 = new Greetings("Good Evening!");
      g1.displayMsg();
      g1.displayMsg();
    }
  }

  @Test
  public void testName() throws Exception {
    Greetings.main(new String[] {"aa"});
  }

  /**
   * String literal is checking the String Pool if similar value already exists. If it does exists
   * it does not create a new object but it reuses existing one. Object initialization always
   * creates new object.
   * https://www.geeksforgeeks.org/string-initialization-java-string-literal-vs-string-object/
   * 
   * In the example below. First instance is created because we use object initialization. Second
   * one is created because it does not exists. s3 is the same reference as s2, because its taken
   * from String pool. At s4, Java does not exists yet in String pool, so its gets created, its
   * third instance. And then s5 is the same reference as s4. At the end there are 3 instances in
   * the JVM memory heap for String type.
   * 
   * You can put and existing String from heap into the String pool with the intern() method.
   * 
   * @throws Exception
   */
  @Test
  public void stringInitialization() throws Exception {
    String s1 = new String("Java"); // Line 3
    String s2 = "JaVa"; // Line 4
    String s3 = "JaVa"; // Line 5
    String s4 = "Java"; // Line 6
    String s5 = "Java"; // Line 7
    int i = 1; // Line 9
  }
}
