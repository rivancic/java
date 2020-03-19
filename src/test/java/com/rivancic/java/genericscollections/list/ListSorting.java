package com.rivancic.java.genericscollections.list;

import static org.junit.Assert.assertEquals;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
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

  /**
   * Comparator of Student1 will be used in List#sort method.
   * And this method is sorting elements by the name descending.
   */
  @Test
  public void main() {
    Student1 stud1 = new Student1("John", "OCA");
    Student1 stud2 = new Student1("Jack", "OCP");
    Student1 stud3 = new Student1("Rob", "OCP");
    List<Student1> list = Arrays.asList(stud1, stud2, stud3);
    list.sort(new Student1());
    list.forEach(System.out::println);
  }
}

class Student1 implements Comparator<Student1> {
  private String name;
  private String exam;

  public Student1() {
    super();
  }

  public Student1(String name, String exam) {
    this.name = name;
    this.exam = exam;
  }

  public int compare(Student1 s1, Student1 s2) {
    return s2.name.compareToIgnoreCase(s1.name);
  }

  public String toString() {
    return '{' + name + ", " + exam + '}';
  }
}
