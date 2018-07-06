package com.rivancic.java.list;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class ListRemove {

  /**
   * {@link List#remove(int)} method returns the element that was present before at that index.<br>
   * In the example below, the list contains String elements. When remove method is executed it
   * returns String value which is not valid as an expression in if statement.
   * 
   * Program throws compilation error if the if statement is not commented out.
   * 
   * 
   * @throws Exception
   */
  @Test
  public void returnValueFromRemoveMethod() throws Exception {
    List<String> list = new ArrayList<>();
    list.add("ONE");
    list.add("TWO");
    list.add("THREE");
    list.add("THREE");

    // Type mismatch: cannot convert from String to boolean
    // if (list.remove(2)) {
    list.remove("THREE");
    // }

    System.out.println(list);
  }

  /**
   * Program will throw {@link IndexOutOfBoundsException} because no elements are yet in the list
   * and we want to insert an element to the position 1. We could anyhow insert an element at the
   * position 0. removal of new Integer would invoke method that removes an object from the list.
   * Because Integer with value 2 is not found none of the elements would be removed. The result of
   * the remove method would be false.
   * 
   * <p>
   * The result would be runtime exception.
   * </p>
   * 
   * @throws Exception
   */
  @Test
  public void removeInteger() throws Exception {
    List<String> trafficLight = new ArrayList<>();
    trafficLight.add(1, "RED");
    trafficLight.add(2, "ORANGE");
    trafficLight.add(3, "GREEN");
    trafficLight.remove(new Integer(2));
    System.out.println(trafficLight);
  }

  /**
   * Because of the wrong equals implementation in Student class remove method will not remove
   * anything from the list of Students because it will use default method from Object class which
   * only checks for the reference.
   */
  @Test
  public void testRemoval() {
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
   * First check at 3 values added to the list. 1. One gets autoboxed into Boolean. Second one
   * evaluates to <code>true</code>, because it parses string ignore casing. And the last one
   * evaluates to false because everything else than true evaluates to false.
   * 
   * Then in the removal part. remove method with int parameter will remove the item at provided
   * position. This means it will remove the item at the second position (list has zero based
   * index). It will evaluate to true. So we will remove another object. Again on second position,
   * this time the last element that holds value false. The result is single element in the list
   * that holds value true.
   * 
   * @throws Exception
   */
  @Test
  public void removalOfBoolean() throws Exception {
    List<Boolean> list = new ArrayList<>();
    list.add(true);
    list.add(new Boolean("tRue"));
    list.add(new Boolean("abc"));

    if (list.remove(1)) {
      list.remove(1);
    }
    assertEquals(1, list.size());
    assertEquals(true, list.get(0));
  }


  /**
   * Boolean array is initialized with null values. Null values are then copied to the list.
   * remove() method on list returns the element that was removed. In case below it removes null, so
   * it also returns null. When the if statement gets evaluated it throws
   * {@link NullPointerException}.
   * 
   * @throws Exception
   */
  @Test(expected = NullPointerException.class)
  public void removeNullValue() throws Exception {
    Boolean[] arr = new Boolean[2];
    List<Boolean> list = new ArrayList<>();
    list.add(arr[0]);
    list.add(arr[1]);
    if (list.remove(0)) {
      list.remove(1);
    }
    System.out.println(list);
  }
}
