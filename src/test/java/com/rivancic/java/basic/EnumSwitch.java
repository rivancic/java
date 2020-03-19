package com.rivancic.java.basic;

import org.junit.Test;

/**
 * Static method valueOf() on a specific Enum type can parse String and converts it to the enum instance.
 * String has to exactly match the enum identifier (case sensitive).
 * Otherwise {@link com.sun.javaws.exceptions.InvalidArgumentException} will be thrown.
 *
 * In case below only STOP will be printed as BLUE is not handled in the switch case. If the handle is missing in the switch case no compiler error is thrown.
 */
public class EnumSwitch {

    enum TrafficLight {
      RED, YELLOW, GREEN, BLUE;
    }

    @Test
    public void main() {
      String[] args = new String[]{"BLUE", "AMBER"};
      TrafficLight tl = TrafficLight.valueOf(args[0]);
      printTrafficLightMeaning(tl);
      printTrafficLightMeaning(TrafficLight.valueOf("RED"));
    }

  private void printTrafficLightMeaning(TrafficLight tl) {
    switch(tl) {
      case RED:
        System.out.println("STOP");
        break;
      case YELLOW:
        System.out.println("SLOW");
        break;
      case GREEN:
        System.out.println("GO");
        break;
    }
  }

}
