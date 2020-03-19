package com.rivancic.java.exceptions;

import java.io.IOException;
import java.sql.SQLException;
import org.junit.Test;


class ReadTheFile {

  static void print() throws Exception { //Line 4
    throw new IOException(); //Line 5
  }
}

public class HandlingException {

  public static void main(String[] args) throws IOException { //Line 10

    try {
      ReadTheFile.print();
    } catch (Exception e)
    // } catch (Exception | IOException e) // In a multi catch statement there can not be exception subclasses
    {
      System.out.println(e.toString());
    }

  }

  /**
   * null value can be thrown. But this itself is throwing NullPointerException.
   *
   * @throws SQLException
   */
  private static void m() throws SQLException {
    try {
      throw new SQLException();
    } catch (Exception e) {
      throw null; //Line 10
    }
  }

  /**
   * NullPointerException will be thrown from m() method not SQLException as one could assume.
   */
  @Test(expected = NullPointerException.class)
  public void testThrowNullException() {
    try {
      m(); //Line 16
    } catch(SQLException e) {
      System.out.println("Caught Successfully.");
    }
  }
}
