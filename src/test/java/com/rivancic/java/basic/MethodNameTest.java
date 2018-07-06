package com.rivancic.java.basic;

/**
 * Method name can be the same as the constructor or class name. We see here the default constructor
 * will actually call the method not the constructor with additional parameters.
 * 
 * @author Renato Ivancic <r.ivancic@dodax.com>
 *
 */
public class MethodNameTest {
  class Student {
    String name;
    int age;

    Student() {
      Student("James", 25);
    }

    Student(String name, int age) {
      this.name = name;
      this.age = age;
    }

    void Student(String name, int age) {
      this.name = name;
      this.age = age;
    }
  }

  @org.junit.Test
  public void testName() throws Exception {
    Student s = new Student();
    System.out.println(s.name + ":" + s.age);
  }


}
