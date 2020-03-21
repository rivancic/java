package com.rivancic.java.basic;

import com.rivancic.java.basic.OuterStaticClass.StaticInner;
import org.junit.Test;

class OuterStaticClass {
  static class StaticInner {

  }
}

public class InnerStaticClassInstatiationTest {

  @Test
  public void test() {

    // static inner class can not be initialized on instance of an outer object
    // StaticInner si = new Outer().new StaticInner();

    // It has to be instantiated from the Static class.
    StaticInner si = new OuterStaticClass.StaticInner();
  }
}
