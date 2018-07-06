package com.rivancic.java.basic;

import org.junit.Test;

public class VoidMethodsNoConstructor {


  class Student {
    String name;
    int age;

    void Student() {
      Student("James", 25);
    }

    void Student(String name, int age) {
      this.name = name;
      this.age = age;
    }
  }


  @Test
  public void testName() throws Exception {
    Student s = new Student();
    System.out.println(s.name + ":" + s.age);
  }

}
