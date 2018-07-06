package com.rivancic.java.exceptions;

import org.junit.Test;

public class ThrownException {
  class TestException extends Exception {
    public TestException() {
      super();
    }

    public TestException(String s) {
      super(s);
    }
  }

  @Test
  public void ExecuteException() throws Exception {
    throw new TestException();
  }
}
