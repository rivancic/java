package com.rivancic.java.genericscollections.set;

public class Dance {

  private String name;
  public Dance(String name) {
    this.name = name;
  }
 
  @Override
  public String toString() {
    return name;
  }

  public int compareTo(Dance dance) {
    
    return this.name.compareTo(dance.name);
  }
}
