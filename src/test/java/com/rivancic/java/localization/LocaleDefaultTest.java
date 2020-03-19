package com.rivancic.java.localization;

import java.util.Locale;
import org.junit.Test;

public class LocaleDefaultTest {

  @Test
  public void testDefaultLocale() {
    Locale loc = new Locale("it", "IT"); //Line 7
    loc.setDefault(loc); //Line 8
    System.out.println(Locale.getDefault());
  }

  /**
   * New custom locales can be created. First parameter in constructor is language the second one is
   * the country.
   *
   * Constructor automatically changes language to lowercase and country to upper case.
   */
  @Test
  public void testNewLocale() {
    Locale locale = new Locale("TEMP", "unknown"); //Line 7
    System.out.println(locale.getLanguage() + ":" + locale.getCountry()); //Line 8
    System.out.println(locale); //Line 9
  }
}
