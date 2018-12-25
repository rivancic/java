package com.rivancic.java.genericscollections.list;

import static org.junit.Assert.assertEquals;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import org.junit.Test;

public class ListSorting {

  /**
   * Product class implements {@link Comparable} interface. This way the class can be sorted in
   * collection with custom rules that are implemented in the {@link Comparable#compareTo(Object)}
   * method. Notice its a functional interface. It returns an integer [-1, 0, 1] that indicate if an
   * item is less, equal or greater than compared one.<br>
   * Elements in a collection must implement Comparable to use the sort method
   *
   */
  class Product implements Comparable<Product> {
    private BigDecimal price;
    private String name;

    Product(BigDecimal price, String name) {
      this.price = price;
      this.name = name;
    }

    /**
     * Sorts by name then by price if the name is the same.
     */
    @Override
    public int compareTo(Product product) {
      return name.equals(product.name) ? price.compareTo(product.price)
        : name.compareTo(product.name);
    }

    @Override
    public String toString() {
      return "Product [price=" + price + ", name=" + name + "]";
    }
  }

  /**
   * First it sorts by name, then by price.
   * 
   * {@link Collections#sort(java.util.List)} accepts list of elements that implements
   * {@link Comparable} interface. The reason why Product have to implement compare method.
   * 
   * Notice of {@link BigDecimal#BigDecimal(String)} constructor. If we pass just decimal number its
   * treated as double. As doubles can not be represented as exact decimal number it can happen that
   * our BigDecimal will not hold the exact value that we want.
   * 
   * @throws Exception
   */
  @Test
  public void sortWithComparable() throws Exception {
    ArrayList<Product> products = new ArrayList<>();
    products.add(new Product(new BigDecimal("74.89"), "Deutsch als Fremdsprache B2 - C1"));
    products.add(new Product(new BigDecimal("18.76"), "AWS for Developers For Dummies"));
    products.add(new Product(new BigDecimal("13.90"), "Agile Projekte mit Scrum, XP und Kanban"));
    products.add(new Product(new BigDecimal("19.92"), "AWS for Developers For Dummies"));
    Collections.sort(products);
    System.out.print(products);
    assertEquals(new BigDecimal("18.76"), products.get(0).price);
    assertEquals(new BigDecimal("19.92"), products.get(1).price);
    assertEquals(new BigDecimal("13.90"), products.get(2).price);
    assertEquals(new BigDecimal("74.89"), products.get(3).price);
  }
}
