package com.rivancic.java.multithreading;

import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Test;

public class RunnableAtomicIntegerTest {

  /**
   * Method will create three threads holding Runnables that point to the same class instance of
   * AtomicInteger. Threads will be started at the same time. We can not predict the order in which
   * they will get executed but the ai variable will be decreased and printed in single step so the
   * result in the console at the end will be 321.
   * 
   * @throws Exception
   */
  @Test
  public void testName() throws Exception {
    Thread t1 = new Thread(new Counter());
    Thread t2 = new Thread(new Counter());
    Thread t3 = new Thread(new Counter());
    Thread[] threads = {t1, t2, t3};
    for (Thread thread : threads) {
      thread.start();
    }
  }
}


class Counter implements Runnable {
  private static AtomicInteger ai = new AtomicInteger(3);

  public void run() {
    System.out.print(ai.getAndDecrement());
  }
}
