package com.rivancic.java.genericscollections;

/**
 * If generic type is not specified at the declaration time then by default it can hold object.
 * The last value set is % that means for the result percentage will be printed out.
 *
 * @param <T>
 */
public class GenericTypeInterchangedTest<T> {

  private T t;

  public T get() {
    return t;
  }

  public void set(T t) {
    this.t = t;
  }

  public static void main(String args[]) {
    GenericTypeInterchangedTest obj = new GenericTypeInterchangedTest();
    obj.set("OCP");
    obj.set(85);
    obj.set('%');

    System.out.println(obj.get());
  }
}
