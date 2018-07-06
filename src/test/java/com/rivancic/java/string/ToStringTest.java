package com.rivancic.java.string;

/**
 * Class can not extend final class String. String class is not meant to be extended. Program will
 * throw compilation exception.
 * 
 * @author Renato Ivancic <r.ivancic@dodax.com>
 *
 */
public class ToStringTest {


  public class Test// extends String
  {
    @Override
    public String toString() {
      return "TEST";
    }

    @org.junit.Test
    public void finalStringClass() throws Exception {
      Test obj = new Test();
      System.out.println(obj);
    }
  }
}
