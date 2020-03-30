package com.rivancic.java.genericscollections;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;
import org.junit.Test;

public class IterableTest {


  /**
   * Fake example of custom Iterable implementation.
   * Now its possible to use for-each loop with Team class.
   */
  class Team implements Iterable<String> {

    List<String> teamMembers = new ArrayList<>();

    @Override
    public Iterator<String> iterator() {
      return teamMembers.iterator();
    }

    @Override
    public void forEach(Consumer<? super String> action) {

    }

    @Override
    public Spliterator<String> spliterator() {
      return null;
    }
  }

  @Test
  public void iterableImplementationTest() {
    Team team = new Team();
    team.teamMembers.add("Contador");
    team.teamMembers.add("Polanc");
    for(String name : team) {
      System.out.println(name);
    }


  }
}
