package com.rivancic.java.date;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import org.junit.Test;

public class InstantTest {

  
  @Test
  public void instantNow() throws Exception {
    Instant instantOfZero = Instant.ofEpochSecond(0);
    LocalDate instantDate = LocalDateTime.ofInstant(instantOfZero, ZoneId.of("UTC")).toLocalDate();
    assertThat(instantDate.getYear(), is(1970));
  }

  @Test
    public void main() {
      System.out.println(Instant.EPOCH);
    }

}
