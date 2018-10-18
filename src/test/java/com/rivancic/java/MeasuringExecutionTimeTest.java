package com.rivancic.java;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;
import org.junit.Test;

/**
 * Class containing different methods of measuring code execution time.
 * 
 * TimeUnit.SECONDS.sleep() method is used only for presentational purpose. In the real applications
 * you'll be measuring the execution time of code execution.
 * 
 * @author Renato Ivancic <r.ivancic@dodax.com>
 *
 */
public class MeasuringExecutionTimeTest {

  /**
   * It measures system clock with nanosecond precision. Only the subtraction of the values holds
   * meaningful information, that is passed nanoseconds.
   * 
   * @throws Exception
   */
  @Test
  public void nanoTime() throws Exception {
    long start = System.nanoTime();
    TimeUnit.SECONDS.sleep(2);
    long end = System.nanoTime();
    System.out.println(".nanoTime() | Time elapsed: " + (end - start) + "nano seconds.");
  }

  /**
   * Instant class can be recording the time events in the application. Instant.now() method returns
   * current Instant from the system clock. Class Duration contains helper method that can calculate
   * the Duration passed between starting and ending Instant.
   * 
   * @throws Exception
   */
  @Test
  public void instant() throws Exception {
    Instant start = Instant.now();
    TimeUnit.SECONDS.sleep(2);
    Instant end = Instant.now();
    System.out.println(
      ".nanoTime() | Time elapsed: " + Duration.between(start, end).toNanos() + "nano seconds.");
  }
}
