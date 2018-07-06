package com.rivancic.java.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.junit.Test;

/**
 * Tpoics: ExecutorService, Callable, Future
 * 
 * @author Renato Ivancic <r.ivancic@dodax.com>
 *
 */
public class ExecutorServiceTest {

  class Printer implements Callable<String> {
    public String call() {
      System.out.println("DONE");
      return null;
    }
  }

  /**
   * The process will reserve thread pool with max n = 1 thread that will execute provided jobs. We
   * provide value returning task to the {@link ExecutorService#submit(Callable)} method. It is
   * returning future result which is not being used. We can not determine when the task will be
   * executed. Passed in Callable just prints DONE and is returning null encapsulated in the Future
   * response. Even if we are not executing {@link Future#get()} method, the Callable will get
   * executed. Next statement will print HELLO and then the executor service will be shut down and
   * remove all the threads from the pool.
   * 
   * The result is printed HELLO and DONE but we can not determine the order of execution.
   * 
   * @throws Exception
   */
  @Test
  public void executorServiceTest() throws Exception {
    ExecutorService es = Executors.newFixedThreadPool(1);
    Future<String> submit = es.submit(new Printer());
    System.out.println("HELLO");
    es.shutdown();
  }

  /**
   * The following method does exactly the same as {@link #executorServiceTest()} with a slight
   * modification. The DONE form callable will be always printed first because with executing
   * {@link Future#get()} we block the execution and wait that the value is resutrned.
   * 
   * The result is printed DONE and then HELLO in this exact order.
   * 
   * @throws Exception
   */
  @Test
  public void executorServiceWithGetTest() throws Exception {
    ExecutorService es = Executors.newFixedThreadPool(1);
    Future<String> submit = es.submit(new Printer());
    submit.get();
    System.out.println("HELLO");
    es.shutdown();
  }
}
