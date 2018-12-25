package com.rivancic.java.stream;

import static org.junit.Assert.assertEquals;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.LongBinaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import org.junit.Test;

/**
 * Java Util function package contains multiple predefined functional interfaces
 * <ul>
 * <li>{@link Consumer}</li>
 * <li>{@link Function}</li>
 * <li>{@link Supplier}</li>
 * <li>{@link Predicate}</li>
 * </ul>
 *
 */
public class FunctionalInterfaces {

  /**
   * There are primitive forms of lambda build in functional interfaces. One could implement all
   * business logic with the generic functional interfaces. There is a big down-side to this, namely
   * if its used with primitive types they have to be boxed before they can be used in the
   * functions. Boxing and unboxing causes considerable memory usage overhead that slows down the
   * program. For this purpose many primitive functional interfaces exists. You can prefix primitive
   * name with functional interface if you want to use it. For example generic interface is
   * {@link Predicate} and primitive one {@link IntPredicate}.
   * 
   * Below is the test, logging the time in nanoseconds for execution of both ways. Guess which
   * approach will be faster.
   */
  @Test
  public void primitivePredicateTest() {
    IntPredicate primitiveIntegerPredicate = number -> number == 1010;
    Predicate<Integer> genericIntegerPredicate = number -> number == 1020;
    long start = 0;
    long end = 0;
    for (int i = 0; i < 100; i++) {
      start = System.nanoTime();
      primitiveIntegerPredicate.test(1010);
      end = System.nanoTime();
      System.out
        .println(".nanoTime() | Time elapsed primitive: " + (end - start) + "nano seconds.");
    }

    for (int i = 0; i < 100; i++) {
      start = System.nanoTime();
      genericIntegerPredicate.test(1020);
      end = System.nanoTime();
      System.out.println(".nanoTime() | Time elapsed generic: " + (end - start) + "nano seconds.");
    }
  }

  /**
   * UnaryOperator extends {@link Function} interface. It accepts one operand and returns the value
   * of the same type as the result of applying the value to the function.
   * 
   * Apply method is inherited from {@link Function} interface.
   * 
   */
  @Test
  public void unaryOperatorTest() {
    UnaryOperator<Integer> unaryOperator = number -> 10 + number;
    Integer tenPlusTen = unaryOperator.apply(10);
    assertEquals(Integer.valueOf(20), tenPlusTen);
  }

  /**
   * Another example of a primitive functional interface. This time the implemented interface is
   * {@link Consumer}. It accepts the parameter and it logs it.
   * 
   * Functional method is accept unlike apply in {@link Function} or test in {@link Predicate}.
   * 
   * @throws Exception
   */
  @Test
  public void primitiveConsumerTest() {
    IntConsumer numberConsumer = number -> System.out.println(number);
    numberConsumer.accept(10);
  }

  /**
   * Binary versions of functional interfaces.
   * 
   * BinaryOperator functional interface single apply method is accepting 2 parameters/operands of
   * the same type. The return object is the same type as the operands.
   * 
   * {@link BinaryOperator#apply(Object, Object)} method is inherited from {@link BiFunction}
   * interface.
   * 
   * There are multiply binary functional interfaces:
   * <ul>
   * <li>{@link BinaryOperator}</li>
   * <li>{@link BiPredicate}</li>
   * <li>{@link BiConsumer}</li>
   * <li>{@link BiFunction}</li>
   * </ul>
   * 
   * There are also primitive versions of BinaryOperators:
   * <ul>
   * <li>{@link IntBinaryOperator}</li>
   * <li>{@link LongBiPredicate}</li>
   * </ul>
   * 
   * Primary versions of binary operators have different names of methods, like:
   * {@link IntBinaryOperator#applyAsInt(int, int)},
   * {@link LongBinaryOperator#applyAsLong(long, long)}.
   */
  @Test
  public void binaryOperatorTest() {
    BinaryOperator<String> binaryOperator =
      (text1, text2) -> text1.toLowerCase() + " " + text2.toUpperCase();

    String resultText = binaryOperator.apply("PeAcE", "War");
    assertEquals("peace WAR", resultText);

    IntBinaryOperator integerBinaryOperator =
      (number1, number2) -> number1 * 3 + number2 + 2;

    int resultNumeric = integerBinaryOperator.applyAsInt(3, 4);
    assertEquals(15, resultNumeric);
  }

  /**
   * Example of conversion of kilometers per hour to miles with the Function functional interface.
   * It will accept Double parameter and it will <b>return</b> Double result.
   */
  @Test
  public void convertingKilometersTest() throws Exception {
    Function<Double, Double> kilometersPerHourToMiles = x -> x * 0.621371;
    double miles = kilometersPerHourToMiles.apply(Double.valueOf("50"));
    assertEquals(31.068, miles, 0.1);
  }
}
