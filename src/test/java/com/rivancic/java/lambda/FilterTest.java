package com.rivancic.java.lambda;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;

/**
 * Generics and collections
 * 
 * Filtering collections using lambda expressions
 * 
 * @author Renato Ivancic <r.ivancic@dodax.com>
 *
 */
public class FilterTest {

  class ProgrammingLanguage {
    String name;
    int complexity;

    ProgrammingLanguage(String name, int complexity) {
      this.name = name;
      this.complexity = complexity;
    }
  }

  /**
   * First form the list stream has to be acquired with {@link List#stream()} method, before
   * applying filter to it. Lambda expression is then passed to
   * {@link Stream#filter(java.util.function.Predicate)} method. Filter method accepts
   * {@link Predicate} functional interface. {@link Predicate} contains
   * {@link Predicate#test(Object)} function which returns true or false based on the actual logic
   * that is implementing. Lambda expression is implementing it in our case. All elements that
   * fulfill test method of a predicate are processed.
   */
  @Test
  public void filterTest() {

    // given
    List<ProgrammingLanguage> programmingLanguages = new ArrayList<>();
    programmingLanguages.add(new ProgrammingLanguage("Java", 3));
    programmingLanguages.add(new ProgrammingLanguage("Assembler", 7));
    programmingLanguages.add(new ProgrammingLanguage("C#", 3));
    programmingLanguages.add(new ProgrammingLanguage("C", 6));


    // when
    List<ProgrammingLanguage> complexProgrammingLanguages = programmingLanguages.stream()
      .filter(programmingLanguage -> programmingLanguage.complexity > 5)
      .collect(Collectors.toList());

    // then
    assertEquals(2, complexProgrammingLanguages.size());
    assertEquals("Assembler", complexProgrammingLanguages.get(0).name);
    assertEquals("C", complexProgrammingLanguages.get(1).name);
  }
}
