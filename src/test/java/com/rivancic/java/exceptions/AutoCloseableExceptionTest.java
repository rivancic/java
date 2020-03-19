package com.rivancic.java.exceptions;

import java.io.IOException;
import java.sql.SQLException;
import org.assertj.core.api.Assertions;
import org.junit.Test;

class MyResource implements AutoCloseable {
  @Override
  public void close() throws IOException{
    throw new IOException("IOException");
  }

  public void execute() throws SQLException {
    throw new SQLException("SQLException");
  }
}

public class AutoCloseableExceptionTest {

  @Test
  public void autoCloseableExceptionTest() {
    try(MyResource resource = new MyResource()) {
      resource.execute();
    } catch(Exception e) {

      // This is the first exception that was thrown in the application
      Assertions.assertThat(e.getMessage()).isEqualTo("SQLException");

      // This is the suppresed exception that was thrown after the SQLException.
      // At the time when the resource was being closed by the java program
      Assertions.assertThat(e.getSuppressed()[0].getMessage()).isEqualTo("IOException");
    }
  }
}
