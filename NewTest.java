package com.rivancic.java;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class NewTest {

  @Test
  public void test1() {
    String[] fruits = {"apple", "banana", "mango", "orange"};
    for (String fruit : fruits) {
      System.out.print(fruit + " ");
      if (fruit.equals("mango")) {
        continue;
      }
      System.out.println("salad!");
      break;
    }
  }

  @Test
  public void ola() {
    Double[] arr = new Double[2];
    System.out.println(arr[0] + arr[1]);
  }

  @Test
  public void ifStatement() {
    /*
     * int grade = 60; if (grade = 60) System.out.println("You passed..."); else
     * System.out.println("You failed...");
     */
  }

  /**
   * 
   * A char is promoted to an int, which takes precedence over autoboxing, so remove(int) is called
   * instead of remove(Object) you may have intuitively expect. You can force the "right" method to
   * be called by boxing the argument yourself: chars.remove(Character.valueOf('a'));
   * 
   * https://stackoverflow.com/questions/38861354/removing-a-character-from-an-arraylist-of-characters
   */
  @Test
  public void testList() {
    List<Character> list = new ArrayList<>();
    list.add(0, 'V');
    list.add('T');
    list.add(1, 'E');
    list.add(3, 'O');

    if (list.contains('O')) {
      list.remove('O');
    }

    for (char ch : list) {
      System.out.print(ch);
    }
  }


  /*
   * class MyLocalDate extends LocalDate {
   * 
   * @Override public String toString() { return super.getDayOfMonth() + "-" + super.getMonthValue()
   * + "-" + super.getYear(); }
   */
}
