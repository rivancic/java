package com.rivancic.java.stream;

import org.junit.Test;
import java.util.Optional;

public class TernaryOptionalTest {

  class Message {
    private String msg = "Good Morning!";
    public Message(String msg) {
      this.msg = msg;
    }

    public Message() {super();}

    public String getMsg() {
      return msg;
    }

    public String toString() {
      return msg;
    }
  }

  @Test
  public void main() {
      Message message = null;
      Optional<Message> optional = Optional.ofNullable(message);
      System.out.println(optional.isPresent() ? optional.get().getMsg() : new Message());
    }

}
