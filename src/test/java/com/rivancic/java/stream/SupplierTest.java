package com.rivancic.java.stream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.function.Supplier;
import org.junit.Test;

public class SupplierTest {

  /**
   * Both {@link DoubleSupplier} and {@link Supplier}<Double> can return double value. Double return
   * object from {@link Supplier}<Double> is unboxed to double.
   * 
   * @throws Exception
   */
  @Test
  public void testDoubleSupplier() {
    DoubleSupplier doubleSupplier = () -> 1.2;
    Supplier<Double> doubleWrapperSupplier = () -> 1.3;

    double resultFromDoubleSupplier = doubleSupplier.getAsDouble();
    double resultFromDoubleWrapperSupplier = doubleWrapperSupplier.get();

    assertThat(resultFromDoubleSupplier, is(1.2));
    assertThat(resultFromDoubleWrapperSupplier, is(1.3));
  }

  /**
   * In case that the {@link Supplier}<Double> returns null value the {@link NullPointerException}
   * will be thrown. This holds for other generic types of {@link Supplier}s that are compatible
   * with primitive types as well.
   */
  @Test(expected = NullPointerException.class)
  public void testDoubleNullValueSupplier() {
    Supplier<Double> doubleWrapperNullSupplier = () -> null;
    double resultFromDoubleWrapperNullSupplier = doubleWrapperNullSupplier.get();
  }
}
