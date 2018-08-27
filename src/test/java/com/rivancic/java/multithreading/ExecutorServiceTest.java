package com.rivancic.java.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.junit.Test;

/**
 * Tpoics: ExecutorService, Callable, Future
 * 
 * Sources:
 * <ul>
 * <li><a href=
 * "https://medium.com/@senanayake.kalpa/fantastic-completablefuture-allof-and-how-to-handle-errors-27e8a97144a0">Medium.com</a></li>
 * <li><a href="https://www.baeldung.com/java-completablefuture">Baedlung</a></li>
 * <li><a href=
 * "https://dzone.com/articles/20-examples-of-using-javas-completablefuture">dzone.com</a></li>
 * <li><a href="https://www.callicoder.com/java-8-completablefuture-tutorial/">Callicoder</a></li>
 * </ul>
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

  /**
   * Another way how to execute the Asynchronous task is by using handy methods of
   * {@link CompletableFuture}. It was introduced in Java8 with the improved Concurrency API.
   * CompletableFuture is at the same time a building block and a framework with about 50 different
   * methods for composing, combining, executing asynchronous computation steps and handling errors.
   * 
   * As the {@link CompletableFuture#runAsync(Runnable)} does not have any Executor specified as the
   * second argument it will execute the tasks with ForkJoinPool.commonPool(). Read here
   * https://stackoverflow.com/questions/45460577/default-forkjoinpool-executor-taking-long-time
   * 
   * Sources: https://www.baeldung.com/java-completablefuture
   * 
   * @throws Exception
   */
  @Test
  public void completableFutureRunAsyncDone() throws Exception {
    CompletableFuture<Void> completablePrintingDone =
      new CompletableFuture<>();
    CompletableFuture.runAsync(() -> System.out.println("DONE"));
    System.out.println("HELLO");
  }

  /**
   * Simple test of running 10 tasks asynchronously with the
   * {@link CompletableFuture#runAsync(Runnable, java.util.concurrent.Executor)} method. As an
   * example Fixed Thread Pool Executor is provided. First 5 tasks will be executed immediately, the
   * next five of them will wait in queue that the occupied threads get available again.
   * 
   * @throws InterruptedException
   */
  @Test
  public void completableFutureRunAsyncDoneWithSpecificExecutor() throws InterruptedException {
    try {
      testThreads();
    } catch (InterruptedException e) {
      e.printStackTrace();
      throw e;
    } catch (ExecutionException e) {
      e.printStackTrace();
    }
    System.out.println("Thread: " + Thread.currentThread().getName() + " HELLO");
  }

  private void testThreads() throws InterruptedException, ExecutionException {

    // For the execution of the asynchronous tasks fixed 5 threads will be available.
    ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
    for (int i = 0; i < 10; i++) {
      new CompletableFuture<>();
      CompletableFuture<Void> runAsync =
        CompletableFuture.runAsync(
          () -> {
            System.out.println("Thread: " + Thread.currentThread().getName() + " DONE");
            try {
              Thread.sleep(200);
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          },

          // Thread pool executor is provided.
          fixedThreadPool);
      runAsync.get();
    }

    // If thread pool is not needed anymore don't forget to shut it down. Threads will be released.
    fixedThreadPool.shutdown();
  }

  /**
   * In case that we need a CompletableFunutre for processing in the future, but in some case we
   * already know the result we can create CompletableFuture with the help of the factory method
   * that created completed one.
   * 
   * @throws Exception
   */
  @Test
  public void completedCompletableFutureDeclaration() throws Exception {
    boolean execute = false;
    CompletableFuture<String> response =
      CompletableFuture.completedFuture("Response initialized infront");
    if (execute) {
      response = getCompletableResponse();
    }
    response.thenAccept(message -> System.out.println(message)).get();
  }

  /**
   * The example where the mocked externall call is actually consumed and the result o that response
   * will be shown to the console.
   * 
   * @throws Exception
   */
  @Test
  public void completedCompletableFutureCall() throws Exception {
    boolean execute = true;
    CompletableFuture<String> response =
      CompletableFuture.completedFuture("Response initialized infront");
    if (execute) {
      response = getCompletableResponse();
    }
    response.thenAccept(message -> System.out.println(message)).get();
  }

  /**
   * Fake some blocking operation. Notice
   * {@link CompletableFuture#supplyAsync(java.util.function.Supplier)} returns
   * {@link CompletableFuture} of a specific type.
   * 
   * @return CompletableFuture containing response from the long running task.
   */
  private CompletableFuture<String> getCompletableResponse() {
    CompletableFuture<String> response =
      CompletableFuture.supplyAsync(() -> "Executed in external service");
    return response;
  }
}
