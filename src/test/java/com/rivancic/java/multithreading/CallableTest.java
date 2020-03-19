package com.rivancic.java.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.junit.Test;

class MyCallable implements Callable<Integer> {
  private Integer i;

  public MyCallable(Integer i) {
    this.i = i;
  }

  public Integer call() throws Exception {
    return --i;
  }
}

public class CallableTest {


  /**
   * Get method on future is throwing checked exceptions.
   */
  @Test
    public void main() throws ExecutionException, InterruptedException {
      ExecutorService es = Executors.newSingleThreadExecutor();
      MyCallable callable = new MyCallable(1);
      System.out.println(es.submit(callable).get());
      es.shutdown();
  }
}
