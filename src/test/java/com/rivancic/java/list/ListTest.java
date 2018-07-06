package com.rivancic.java.list;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class ListTest {


  @Test
  public void listInitialization() throws Exception {
    List<String> list = new ArrayList<String>();
    List<String> listWithDiamond = new ArrayList<>();
  }

  /**
   * The approach of how to remove items from the list if we know the value of the item that we want
   * to remove but not the index itself.
   */
  @Test
  public void listRemovalWithIndexOf() {
    List<Integer> list = new ArrayList<Integer>();
    list.add(new Integer(2));
    list.add(new Integer(1));
    list.add(new Integer(0));

    list.remove(list.indexOf(0));

    System.out.println(list);
  }

  class Student {
    private String name;
    private int age;

    Student(String name, int age) {
      this.name = name;
      this.age = age;
    }

    public String toString() {
      return "Student[" + name + ", " + age + "]";
    }
  }

  /**
   * Wont remove any of the values from the list. Because newly created Student object is not equal
   * to any other student item inside of the list. If we would want to use removal method this way
   * we would need to override equals and hashCode methods of Student class. Or use reference to the
   * items in the list.
   */
  @Test
  public void listRemovalWithObject() {
    List<Student> students = new ArrayList<>();
    students.add(new Student("James", 25));
    students.add(new Student("James", 27));
    students.add(new Student("James", 25));
    students.add(new Student("James", 25));

    students.remove(new Student("James", 25));

    for (Student stud : students) {
      System.out.println(stud);
    }
  }

  /**
   * It tries to remove item at index 100 which does not exists.<br>
   * The result it IndexOutOfBoundsException
   */
  @Test
  public void removeInteger() {
    List<Integer> list = new ArrayList<>();
    list.add(100);
    list.add(200);
    list.add(100);
    list.add(200);
    list.remove(100);
    System.out.println(list);
  }

  /**
   * Removes the first occurrence of 4000.<br>
   * The result is [100, 200, 100]
   */
  @Test
  public void removeIntegerWrapper() {
    List<Integer> list = new ArrayList<>();
    list.add(100);
    list.add(200);
    list.add(100);
    list.add(4000);
    list.remove(new Integer(4000));
    System.out.println(new Integer(4000) == ((Integer) 4000));
    System.out.println((new Integer(4000)).equals((Integer) 4000));
    System.out.println(list);
  }

  @Test
  public void order() throws Exception {
    List<String> list = new ArrayList<>();
    list.add(0, "Array");
    list.add(0, "List");

    System.out.println(list);
    assertEquals("List", list.get(0));
    assertEquals("Array", list.get(1));
  }

  @Test
  public void insertingElements() throws Exception {
    List<String> list = new ArrayList<>();
    list.add(0, "Array");
    list.add(0, "List");

    System.out.println(list);
    assertEquals("List", list.get(0));
    assertEquals("Array", list.get(1));
  }

  @Test
  public void insertAndOverwriteElement() throws Exception {
    List<String> list = new ArrayList<>();
    list.add(0, "Array");
    list.set(0, "List");
    System.out.println(list);
    assertEquals(1, list.size());
    assertEquals("List", list.get(0));
  }
}
