package com.rivancic.java.model;

public class Person {

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + age;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((sex == null) ? 0 : sex.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Person other = (Person) obj;
    if (age != other.age)
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (sex != other.sex)
      return false;
    return true;
  }

  public Person(String name, Gender sex, int age) {
    this.name = name;
    this.sex = sex;
    this.age = age;
  }

  public String name;
  public Gender sex;
  public int age;
}
