package com.rivancic.java.basic.types;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class BooleanConstructor {

  /**
   * <h1>Documentation of Boolean(String) constructor</h1>
   * <p>
   * Allocates a Boolean object representing the value true if the string argument is not null and
   * is equal, ignoring case, to the string "true". Otherwise, allocate a Boolean object
   * representing the value false. Examples: new Boolean("True") produces a Boolean object that
   * represents true. new Boolean("yes") produces a Boolean object that represents false.
   * </p>
   * 
   * <p>
   * What will be the value in booleanTextConcatenation?
   * </p>
   * 
   * <p>
   * Take note about {@link Boolean#toString()} documentation <br>
   * Returns a String object representing this Boolean's value. If this object represents the value
   * true, a string equal to "true" is returned. Otherwise, a string equal to "false" is returned.
   * </p>
   * 
   */
  @Test
  public void booleanConstructor() throws Exception {
    Boolean boolean1 = new Boolean("trUE");
    Boolean boolean2 = new Boolean("FAlse");
    Boolean boolean3 = new Boolean("something");
    Boolean boolean4 = null;
    String booleanTextConcatenation = boolean1 + ":" + boolean2 + ":" + boolean3 + ":" + boolean4;
    System.out.println(booleanTextConcatenation);
    assertEquals("true:false:false:null", booleanTextConcatenation);
  }

  /**
   * Check {@link Boolean} constructor documentation. If the parameter is not "true" ignoring casing
   * then the result is false.
   * 
   * @throws Exception
   */
  @Test
  public void booleanConstructorNotTrue() throws Exception {
    assertEquals(false, new Boolean("ture"));
  }
}
