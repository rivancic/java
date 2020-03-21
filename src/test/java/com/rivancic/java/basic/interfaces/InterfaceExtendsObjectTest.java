package com.rivancic.java.basic.interfaces;

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * Every interface actually extends Object class.
 * This comment explains it a bit differently tough https://stackoverflow.com/questions/13776018/does-an-interface-by-default-extend-object
 *
 * At least message in IDE for equals method says its overriden form Object class.
 */
public class InterfaceExtendsObjectTest {

  @FunctionalInterface
  interface ObjectOverridingInterface {
    void print();
    boolean equals(Object o);
    int hashCode();
  }

  @Test
  public void test() {
    ObjectOverridingInterface objectOverridingInterface = () -> System.out.println("ObjectOverridingInterface");
    boolean isJoEqual = objectOverridingInterface.equals(new Object());
    int hash = objectOverridingInterface.hashCode();
    Assertions.assertThat(isJoEqual).isEqualTo(false);
    Assertions.assertThat(hash).isGreaterThan(0);
  }
}
