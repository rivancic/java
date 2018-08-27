package com.rivancic.java.multithreading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import org.junit.Test;

/**
 * How to execute multiple tasks asynchronously with {@link CompletableFuture} and wait/merge the
 * results.
 * 
 * @author Renato Ivancic <r.ivancic@dodax.com>
 *
 */
public class CompletalbeFutureMultiple {

  /**
   * We have two CompletableFutures. We want both to be executed in asynchronous manner. Then we
   * want to wait that they finish and handle the result. First one will take 2 seconds the second
   * one 1 second. The total time should be 2 seconds.
   * 
   * @throws Exception
   */
  @Test
  public void testName() throws Exception {

    CompletableFuture<String> completableFutureString = CompletableFuture.supplyAsync(() -> {
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      return "Task 1";
    });

    CompletableFuture<Integer> completableFutureInteger = CompletableFuture.supplyAsync(() -> {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      return 1;
    });

    // Merge CompletableFutures and wait that all of them finish. If one is terminating
    // exceptionally the result CompletableFuture will also have exceptional state.
    // With .thenAccept we provide the supplier that prints out values if the computation is
    // successful.
    CompletableFuture.allOf(completableFutureString, completableFutureString).get(4,
      TimeUnit.SECONDS);

    // Printing values sequential.
    System.out.println("Result of first Future: " + completableFutureString.get());
    System.out.println("Result of second Future: " + completableFutureInteger.get());

  }
}
