package com.rivancic.java.testdome;

import static org.junit.Assert.assertTrue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.Test;

public class UsernameValidation {

  private static final String pattern = "(^\\w)(\\w|-){5,15}([^-]$)";

  public static boolean validate(String username) {
    Pattern r = Pattern.compile(pattern);
    Matcher m = r.matcher(username);
    return m.matches();
  }


  @Test
  public void testName() throws Exception {
    assertTrue(validate("Mike-Standish")); // Valid username
    assertTrue(validate("Mike-Standis-")); // Valid username
    // assertTrue(validate("-ike-Standish")); // Valid username
    // assertFalse(validate("Mike Standish")); // Invalid username
    // assertFalse(validate("Mik")); // Invalid username
    // assertFalse(validate("Mikalksjdakjdlaksdlksad")); // Invalid username
  }
}
