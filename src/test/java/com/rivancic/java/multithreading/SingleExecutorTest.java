package com.rivancic.java.multithreading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.junit.Test;

public class SingleExecutorTest {
  @Test
  public void main() throws InterruptedException, ExecutionException {
    ExecutorService es = Executors.newSingleThreadExecutor();
    Future<String> f = es.submit(() -> "HELLO");
    System.out.println(f.get());
    es.shutdown();
  }
}
