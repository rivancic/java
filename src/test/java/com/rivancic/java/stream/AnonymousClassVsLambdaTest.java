package com.rivancic.java.stream;

import org.junit.Test;

/**
 * Parameter operator in the println method will not do anything on itself.
 * println of a PrintStream will just print out default string representation of an anonymous class.
 *
 * Something like com.rivancic.java.stream.AnonymousClassVsLambdaTest$1@3830f1c0
 *
 * And in the second case default text representation of a Lambda is printed to the console.
 * Its a bit different than the output of Operator Anonymous class.
 */
public class AnonymousClassVsLambdaTest {

  @Test
  public void test() {
    System.out.println(new Operator<String>() {

      public String operation(String s1, String s2) {
        return s1 + s2;
      }
    });

    Operator<String> stringOperator = (s1, s2) -> s1 + s1;
    System.out.println(stringOperator);
  }
}

interface Operator<T> {
  public abstract T operation(T t1, T t2);
}