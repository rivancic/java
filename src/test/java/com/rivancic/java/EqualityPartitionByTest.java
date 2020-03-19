package com.rivancic.java;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Certification {
  String studId;
  String test;
  int marks;

  Certification(String studId, String test, int marks) {
    this.studId = studId;
    this.test = test;
    this.marks = marks;
  }

  public String toString() {
    return "{" + studId + ", " + test + ", " + marks + "}";
  }

  public String getStudId() {
    return studId;
  }

  public String getTest() {
    return test;
  }

  public int getMarks() {
    return marks;
  }
}

public class EqualityPartitionByTest {
  public static void main(String[] args) {
    Certification c1 = new Certification("S001", "OCA", 87);
    Certification c2 = new Certification("S002", "OCA", 82);
    Certification c3 = new Certification("S001", "OCP", 79);
    Certification c4 = new Certification("S002", "OCP", 89);
    Certification c5 = new Certification("S003", "OCA", 60);
    Certification c6 = new Certification("S004", "OCA", 88);

    Stream<Certification> stream = Stream.of(c1, c2, c3, c4, c5, c6);
    Map<Boolean, List<Certification>> map =
      stream.collect(Collectors.partitioningBy(s -> s.equals("OCA")));
    System.out.println(map.get(true));
  }
}