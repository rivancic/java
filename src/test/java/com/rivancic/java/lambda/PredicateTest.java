package com.rivancic.java.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import org.junit.Test;

public class PredicateTest {
  class Employee {
    private String name;
    private int age;
    private double salary;

    public Employee(String name, int age, double salary) {
      this.name = name;
      this.age = age;
      this.salary = salary;
    }

    public String getName() {
      return name;
    }

    public int getAge() {
      return age;
    }

    public double getSalary() {
      return salary;
    }

    public String toString() {
      return name;
    }
  }

  /**
   * Which of the following lambda expressions, if used to replace \/*INSERT*\/, prints [Jack, Liya]
   * on to the console? <br>
   * - e -> {e.getSalary() >= 10000}<br>
   * + e -> e.getSalary() >= 10000<br>
   * - (e) -> {e.getSalary() >= 10000;}<br>
   * - e - > e.getSalary() >= 10000<br>
   * + (Employee e) -> {return e.getSalary() >= 10000;}<br>
   *
   */
  @Test
  public void testPredicate() throws Exception {
    List<Employee> list = new ArrayList<>();
    list.add(new Employee("James", 25, 15000));
    list.add(new Employee("Lucy", 23, 12000));
    list.add(new Employee("Bill", 27, 10000));
    list.add(new Employee("Jack", 19, 5000));
    list.add(new Employee("Liya", 20, 8000));
    process(list, e -> e.getSalary() > 0);
    System.out.println(list);
  }

  private static void process(List<Employee> list, Predicate<Employee> predicate) {
    Iterator<Employee> iterator = list.iterator();
    while (iterator.hasNext()) {
      if (predicate.test(iterator.next()))
        iterator.remove();
    }
  }


  /**
   * The process will print 1.1. to the console. With predicate applied to the filter it will run
   * the first time when the value is -80. The result will be false. Then the next element in the
   * list will be passed to the stream and filter will request the value from the predicate which
   * will return true. As the terminal operator is findFirst from the filter additional filtering is
   * not required anymore. Value ctr inside the lambda body is local and always initialized to one.
   * This is the reason 1 is printed two times.
   * 
   * Link: https://stackoverflow.com/questions/23696317/find-first-element-by-predicate
   * 
   * @throws Exception
   */
  @Test
  public void testStreamLazyFilterPredicate() throws Exception {
    List<Integer> list = Arrays.asList(-80, 100, -40, 25, 200);
    Predicate<Integer> predicate = num -> {
      int ctr = 1;
      boolean result = num > 0;
      System.out.print(ctr++ + ".");
      return result;
    };
    list.stream().filter(predicate).findFirst();
  }
}
