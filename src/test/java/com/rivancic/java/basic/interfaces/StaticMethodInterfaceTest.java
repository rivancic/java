package com.rivancic.java.basic.interfaces;

import org.junit.Test;

/**
 * Default methods can be overriden in interfaces.
 *
 * Static methods can not be inherited by the concrete class.
 * One can not call static method form interface on a concrete class, this is the shortcoming
 * of interface static methods.
 *
 * https://stackoverflow.com/questions/31788841/static-and-non-static-method-in-one-class-with-the-same-name-java
 */
interface DefaultMethodBase {
  default void call() {  System.out.println("DefaultMethodBase.call()");}
}

interface DefaultMethodSubclass extends DefaultMethodBase {

  @Override
  default void call() {  System.out.println("DefaultMethodSubclass.call()");}
}

interface StaticMethod {

  static void call() {  System.out.println("StaticMethod.call()");}
}

public class StaticMethodInterfaceTest implements DefaultMethodSubclass, StaticMethod {

  @Test
  public void testInvocation() {

    new StaticMethodInterfaceTest().call();

    // Will throw compilation error
    // StaticMethodInterfaceTest.call();
  }
}
