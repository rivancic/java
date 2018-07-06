package com.rivancic.java.basic;

import org.junit.Test;

public class ParameterTypeTest {

  @org.junit.Test
  public void testName() throws Exception {
    Student student = new Student("James", 25);
    int marks = 25;
    review(student, marks);
    System.out.println(marks + "-" + student.marks);
  }

  private static void review(Student stud, int marks) {
    marks = marks + 10;
    stud.marks += marks;
  }

  public static void change(Message m) {
    m = new Message();
    m.msg = "Happy Holidays!";
  }

  @Test
  public void referenceParameter() throws Exception {

    Message obj = new Message();
    obj.print();
    change(obj);
    obj.print();
  }
}


class Student {
  String name;
  int marks;

  Student(String name, int marks) {
    this.name = name;
    this.marks = marks;
  }
}


class Message {
  String msg = "Happy New Year!";

  public void print() {
    System.out.println(msg);
  }
}
