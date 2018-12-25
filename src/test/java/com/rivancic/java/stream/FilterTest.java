package com.rivancic.java.stream;

import static org.junit.Assert.assertEquals;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;

/**
 * Generics and collections. Java Stream API.
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
   * <h1>The test with filtering consists form 3 steps.</h1>
   * <p>
   * 1. Stream is created.
   * </p>
   * <p>
   * 2. It is filtered with {@link Stream#filter(Predicate)} method.
   * </p>
   * <p>
   * 3. Elements are collected with the {@link Stream#collect(java.util.stream.Collector)} method to
   * aggregate elements of the stream to the list with the toList collector.
   * </p>
   * Lambda expression is passed to {@link Stream#filter(java.util.function.Predicate)} method.
   * Filter method accepts {@link Predicate} functional interface. {@link Predicate} contains
   * {@link Predicate#test(Object)} function which returns true or false based on the actual logic
   * that is implementing. Lambda expression is implementing it in our case. All elements that
   * fulfill test method of a predicate are processed.
   */
  @Test
  public void filterTestWithList() {

    // given
    Stream<ProgrammingLanguage> programmingLanguages = Stream.of(new ProgrammingLanguage("Java", 3),
      new ProgrammingLanguage("Assembler", 7),
      new ProgrammingLanguage("C#", 3),
      new ProgrammingLanguage("C", 6));


    // when
    List<ProgrammingLanguage> complexProgrammingLanguages = programmingLanguages
      .filter(programmingLanguage -> programmingLanguage.complexity > 5)
      .collect(Collectors.toList());

    // then
    assertEquals(2, complexProgrammingLanguages.size());
    assertEquals("Assembler", complexProgrammingLanguages.get(0).name);
    assertEquals("C", complexProgrammingLanguages.get(1).name);
  }
}
