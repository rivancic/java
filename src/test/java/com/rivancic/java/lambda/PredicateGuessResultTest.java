package com.rivancic.java.lambda;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import org.junit.Test;

public class PredicateGuessResultTest {
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
   * When calling process method, the result list will contain<br>
   * James, Lucy, Bill
   * 
   * @throws Exception
   */
  @Test
  public void guessWhatIsTheOutput() throws Exception {
    List<Employee> list = new ArrayList<>();
    list.add(new Employee("James", 25, 15000));
    list.add(new Employee("Lucy", 23, 12000));
    list.add(new Employee("Bill", 27, 10000));
    list.add(new Employee("Jack", 19, 5000));
    list.add(new Employee("Liya", 20, 8000));
    List<Employee> filteredEmployees = process(list, e -> e.getAge() > 20);
    System.out.println(filteredEmployees);
    assertEquals("James", filteredEmployees.get(0).toString());
    assertEquals("Lucy", filteredEmployees.get(1).toString());
    assertEquals("Bill", filteredEmployees.get(2).toString());
  }


  private List<Employee> process(List<Employee> list, Predicate<Employee> predicate) {
    List<Employee> employees = new ArrayList<>();
    Iterator<Employee> iterator = list.iterator();
    while (iterator.hasNext()) {
      Employee employee = iterator.next();
      if (predicate.test(employee))
        employees.add(employee);
    }
    return employees;
  }
}
