package com.rivancic.java.localization;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import java.util.Locale;
import org.junit.Test;

public class LocaleTest {

  /**
   * First parameter in Locale constructor creates language, the second one country.
   * 
   * @throws Exception
   */
  @Test
  public void createLocalization() throws Exception {
    Locale hindi = new Locale("hi");
    Locale hindiIndia = new Locale("hi", "IN");
    /**
     * This constructor does not create locale with a country India but uses the first parameter to
     * decide the language which is Indonesian.
     */
    Locale india = new Locale("IN");
    /**
     * For the following locale the language is Indonesian but the correct country can not be
     * assigned. It will be set just as HI.
     */
    Locale indiaHindi = new Locale("IN", "hi");

    assertThat(hindi.getDisplayName(), is("Hindi"));
    assertThat(hindiIndia.getDisplayName(), is("Hindi (India)"));
    assertThat(india.getDisplayName(), is("Indonesian"));
    assertThat(indiaHindi.getDisplayName(), is("Indonesian (HI)"));
  }

}
