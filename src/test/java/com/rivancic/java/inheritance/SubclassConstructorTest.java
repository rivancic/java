package com.rivancic.java.inheritance;

import org.junit.Test;

public class SubclassConstructorTest {

  /**
   * Does not have default empty constructor.
   *
   */
  abstract class Animal {
    private String name;

    Animal(String name) {
      this.name = name;
    }

    public String getName() {
      return name;
    }
  }

  class Cat extends Animal {
    private String type;

    /**
     * If super class does not define any constructor without parameters we have to call it
     * explicitly inside of the constructor of subclasses. Super constructor call has to be the
     * first statement.
     */
    Cat(String type) {
      super(""); //
      this.type = type;
    }

    // Would crash because super with String parameter is not called
    // Cat(String type) {
    // this.type=type;
    // }

    Cat(String name, String type) {
      super(name);
      this.type = type;
    }

    public String getType() {
      return type;
    }
  }

  @Test
  public void subclassConstructorsRules() {
    Cat cat1 = new Cat("Siamese");
    Cat cat2 = new Cat("Fluffy", "Domestic");
    System.out.println(cat1.getName() + ":" + cat1.getType() + ":" +
      cat2.getName() + ":" + cat2.getType());
  }
}
