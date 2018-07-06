package com.rivancic.java.list;

public class Student {
  private String name;
  private int age;

  Student(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String toString() {
    return "Student[" + name + ", " + age + "]";
  }

  /**
   * This equals method will not act as expected. If we annotate it with {@link Override} annotation
   * it will give us an compilation error because the parameter type does not apply to signature of
   * the Object type. Parameter type should be of Object not Student.
   * 
   * <p>
   * For above reason this method will not be called in case equals from java API method will be
   * invoked on Student class.
   * </p>
   * 
   * @param obj
   * @return
   */
  public boolean equals(Student obj) {
    if (obj instanceof Student) {
      Student stud = (Student) obj;
      if (this.name.equals(stud.name) && this.age == stud.age) {
        return true;
      }
    }
    return false;
  }

}
