package com.rivancic.java.basic;

import com.rivancic.java.basic.B1.B2;
import com.rivancic.java.basic.TestInterface.A1;
import com.rivancic.java.basic.TestInterface.A2;
import org.junit.Test;

interface TestInterface {
  void m1();

  interface I2 {
    void m2();
  }

  abstract class A1 {
    public abstract void m3();
  }

  class A2 {
    public void m4() {
      System.out.println(4);
    }
  }
}

class B1 {

  class B2 {

  }
}

public class InterfaceWithSubclassesTest {

@Test
  public void testInvocation() {
  TestInterface te = new TestInterface() {

    @Override
    public void m1() {

    }

  };
  A1 a2 = new TestInterface.A1(){
    public void m3() {

    }
  };

  B1 b1 = new B1();
  B2 b2 = b1.new B2();
}
}
