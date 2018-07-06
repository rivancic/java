package com.rivancic.java.basic;

import org.junit.Test;

class ClassTest {

  @Test
  public void testTrickyAssignmentMethod() throws Exception {
    Point p1 = new Point();
    p1.x = 10;
    p1.y = 20;
    Point p2 = new Point();
    p2.assign(p1.x, p1.y);
    System.out.println(p1.toString() + ";" + p2.toString());
  }

  class Point {
    int x;
    int y;

    void assign(int x, int y) {
      x = this.x;
      this.y = y;
    }

    public String toString() {
      return "Point(" + x + ", " + y + ")";
    }
  }


  /**
   * ClassCastException will be thrown because superclass can not be converted to subclass. The
   * conversation in other direction works. Subclass -> superclass.
   * 
   * @throws Exception
   */
  @Test
  public void subclassToSuperClassConversation() throws Exception {
    B objb = new B();
    A obja = (A) objb;
    obja.print();
  }

  /**
   * Will pass
   * 
   * @throws Exception
   */
  @Test
  public void superClassToSubclassConversation() throws Exception {
    A obj1 = new A();
    B obj2 = (B) obj1;
    obj2.print();
  }
}


class A {
  public void print() {
    System.out.println("A");
  }
}


class B extends A {
  public void print() {
    System.out.println("B");
  }
}
