package com.rivancic.java.basic.interfaces;

import org.assertj.core.api.Assertions;
import org.junit.Test;

interface DefaultMethod {
  default double getDouble() {return 0.0;}
}

@FunctionalInterface
interface OverridenAbstractMethod extends DefaultMethod{

  @Override
  abstract double getDouble();
}

/**
 * Default method in an interface can later be overriden with an abstract method.
 * This is legal.
 */
public class InterfaceOverrideMethodTest {

  @Test
    public void testInitialization() {
     OverridenAbstractMethod oam = () -> 1.0;

     Assertions.assertThat(oam.getDouble()).isEqualTo(1.0);
    }
}
