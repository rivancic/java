package com.rivancic.java.lambda;

import static org.junit.Assert.assertEquals;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import org.junit.Test;

/**
 * Topics: {@link Stream}, {@link Collectors}
 * 
 * {@link DoubleStream} can be used to find max or largest value in array, find min or smallest
 * value in array, sum all elements in array, and average of all values in array.
 * 
 * Same goes for the {@link IntStream} and {@link LongStream}.
 * 
 * @author Renato Ivancic <r.ivancic@dodax.com>
 *
 */
public class PrimitiveStreamTest {

  class AccountingPosition {

    AccountingPosition(String name, double value) {
      this.name = name;
      this.value = value;
    }

    String name;
    double value;
  }

  /**
   * From all the accounting positions {@link DoubleStream} is created with
   * {@link Stream#mapToDouble(java.util.function.ToDoubleFunction)} function. From Double stream we
   * can get statistical values like min, max, average.
   */
  @Test
  public void streamToSetTest() throws Exception {
    double monthlyBalance =
      getAccountingPositionsStream().mapToDouble(accountingPosition -> accountingPosition.value)
        .sum();
    System.out.println(monthlyBalance);
    assertEquals(true, monthlyBalance == 2430);

    OptionalDouble min =
      getAccountingPositionsStream().mapToDouble(accountingPosition -> accountingPosition.value)
        .min();
    assertEquals(true, min.isPresent());
    assertEquals(true, min.getAsDouble() == -450);

    OptionalDouble max =
      getAccountingPositionsStream().mapToDouble(accountingPosition -> accountingPosition.value)
        .max();
    assertEquals(true, max.isPresent());
    assertEquals(true, max.getAsDouble() == 3000);

    OptionalDouble average =
      getAccountingPositionsStream().mapToDouble(accountingPosition -> accountingPosition.value)
        .average();
    assertEquals(true, average.isPresent());
    assertEquals(true, average.getAsDouble() == 810);
  }

  private Stream<AccountingPosition> getAccountingPositionsStream() {
    Stream<AccountingPosition> accountingPositions =
      Stream.of(new AccountingPosition("Salary", 3000), new AccountingPosition("Rent", -450),
        new AccountingPosition("Hosting", -120));
    return accountingPositions;
  }
}
