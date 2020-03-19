package com.rivancic.java.basic;

import java.io.IOException;
import java.sql.SQLException;
import org.junit.Test;

public class EqualityOverloadingTest {

@Test
    public void main() {
      Object p1 = new Player1("Sachin", 44);
      Object p2 = new Player1("Sachin", 44);
      System.out.println(p1.equals(p2));


    }

    @Test
      public  void main1() {
        // testing purposes
      }

}



class Player1 {
  String name;
  int age;

  Player1(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String toString() {
    return name + ", " + age;
  }

  public boolean equals(Player1 player) {
    if(
      player != null &&
      this.name.equals(player.name) &&
      this.age == player.age) {
      return true;
    }
    return false;
  }
}
