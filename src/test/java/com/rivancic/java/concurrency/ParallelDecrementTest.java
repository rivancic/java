package com.rivancic.java.concurrency;

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Test;

/**
 * Proper way of dealing with parallel access to static variable with using the
 * AtomicInteger and {@link AtomicInteger#decrementAndGet()}
 */
public class ParallelDecrementTest {

  @Test
  public void invokeThreads() throws InterruptedException {

    Thread t1 = new Thread(new Counter());
    Thread t2 = new Thread(new Counter());
    Thread t3 = new Thread(new Counter());
    Thread t4 = new Thread(new Counter());
    Thread[] threads = {t1, t2, t3, t4};
    ExecutorService es = Executors.newFixedThreadPool(10);
    Counter.i=threads.length;
    System.out.println("\n\nRunnables:");
    for(Thread thread: threads) {
      es.execute(thread);
    }
    es.shutdown();
    es.awaitTermination(1, TimeUnit.MINUTES);
  }


  @Test
  public void invokeCallables() throws InterruptedException {


    Callable<Void> c1 = new Counter();
    Callable<Void> c2 = new Counter();
    Callable<Void> c3 = new Counter();
    Callable<Void> c4 = new Counter();
    Callable<Void> c5 = new Counter();
    Callable<Void> c6 = new Counter();
    Callable<Void> c7 = new Counter();
    Callable<Void> c8 = new Counter();
    Callable<Void> c9 = new Counter();
    Callable<Void> c10 = new Counter();

    Callable<Void>[] callables = new Callable[]{c1, c2, c3, c4, c5, c6, c7, c8, c9, c10};
    Counter.i=callables.length;

    ExecutorService es = Executors.newFixedThreadPool(10);
    System.out.println("\n\nCallables:");
    es.invokeAll(Arrays.asList(callables));

    es.shutdown();
    es.awaitTermination(1, TimeUnit.MINUTES);
  }

}

class Counter implements Callable<Void>, Runnable {

  public static int i = 10;

  public Void call() {
    System.out.print(i-- + " ");
    return null;
  }

  public void run() {
    System.out.print(i-- + " ");
  }
}

