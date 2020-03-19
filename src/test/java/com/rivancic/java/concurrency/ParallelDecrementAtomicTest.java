package com.rivancic.java.concurrency;

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Test;

/**
 * Try to execute decrement operation upon static variable to get the result of inconsistent state
 *
 * Did not get the expected result. Static variable is always decreased without overlapping.
 *
 * Proper way is to use AtomicInteger and {@link AtomicInteger#decrementAndGet()}
 */
public class ParallelDecrementAtomicTest {

  @Test
  public void invokeThreads() throws InterruptedException {

    Thread t1 = new Thread(new AtomicCounter());
    Thread t2 = new Thread(new AtomicCounter());
    Thread t3 = new Thread(new AtomicCounter());
    Thread t4 = new Thread(new AtomicCounter());
    Thread[] threads = {t1, t2, t3, t4};
    ExecutorService es = Executors.newFixedThreadPool(10);
    AtomicCounter.i=new AtomicInteger(threads.length);
    System.out.println("\n\nRunnables:");
    for(Thread thread: threads) {
      es.execute(thread);
    }
    es.shutdown();
    es.awaitTermination(1, TimeUnit.MINUTES);
  }


  @Test
  public void invokeCallables() throws InterruptedException {


    Callable<Void> c1 = new AtomicCounter();
    Callable<Void> c2 = new AtomicCounter();
    Callable<Void> c3 = new AtomicCounter();
    Callable<Void> c4 = new AtomicCounter();
    Callable<Void> c5 = new AtomicCounter();
    Callable<Void> c6 = new AtomicCounter();
    Callable<Void> c7 = new AtomicCounter();
    Callable<Void> c8 = new AtomicCounter();
    Callable<Void> c9 = new AtomicCounter();
    Callable<Void> c10 = new AtomicCounter();

    Callable<Void>[] callables = new Callable[]{c1, c2, c3, c4, c5, c6, c7, c8, c9, c10};
    AtomicCounter.i=new AtomicInteger(callables.length);

    ExecutorService es = Executors.newFixedThreadPool(10);
    System.out.println("\n\nCallables:");
    es.invokeAll(Arrays.asList(callables));

    es.shutdown();
    es.awaitTermination(1, TimeUnit.MINUTES);
  }

}

class AtomicCounter implements Callable<Void>, Runnable {

  public static AtomicInteger i = new AtomicInteger(10);

  public Void call() {
    System.out.print(i.getAndDecrement() + " ");
    return null;
  }

  public void run() {
    System.out.print(i.decrementAndGet() + " ");
  }
}

