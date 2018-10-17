package com.rivancic.java.jvm;

import org.junit.Test;

public class JVM {

  /**
   * 
   * force JVM to run Garbage Collector?
   * 
   * a) By calling: System.gc()
   * 
   * b) By calling: Runtime.getRuntime().gc();
   * 
   * c) By setting the reference variable to null.
   * 
   * d) JVM cannot be forced to run Garbage Collector.
   * 
   * 
   * Strange this is single choice answer question. If a) would be the correct answer then b) should
   * also be the correct one. So this probably hints that you can not really trigger GC. You can
   * only ask JVM to try to run it ASAP.
   * 
   * Stack overflow discussion:
   * https://stackoverflow.com/questions/1481178/how-to-force-garbage-collection-in-java
   * 
   * @throws Exception
   */
  @Test
  public void jvmTest() throws Exception {

  }
}
