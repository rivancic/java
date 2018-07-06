package com.rivancic.java.basic.staticblocks;

import java.util.ArrayList;
import java.util.List;

/**
 * Every list instance in static block is a new instance inside of scope and it is not connected to
 * other list instances. So no errors will be thrown beacuse of incompatible generic types. But in
 * the fourth block. Mammal can not be added to the Sellable list because Mammal is not of type
 * sellable.
 * 
 * @author Renato Ivancic <r.ivancic@dodax.com>
 *
 */
public class StaticBlock {
  interface Sellable {
  }
  abstract class Animal {
  }
  class Mammal extends Animal {
  }
  class Rabbit extends Mammal implements Sellable {
  }

  {
    List<Animal> list = new ArrayList<>();
    list.add(new Rabbit());
  }
  {
    List<Animal> list = new ArrayList<>();
    list.add(new Mammal());
  }
  {
    List<Mammal> list = new ArrayList<>();
    list.add(new Rabbit());
  }
  {
    List<Sellable> list = new ArrayList<>();
    // list.add(new Mammal());
  }
  {
    List<Sellable> list = new ArrayList<>();
    list.add(new Rabbit());
  }

  @org.junit.Test
  public void testOrderOfInitializationBlocks() throws Exception {

  }
}
