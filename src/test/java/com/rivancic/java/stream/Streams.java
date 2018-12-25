package com.rivancic.java.stream;

import com.rivancic.java.model.Gender;
import com.rivancic.java.model.Person;
import com.rivancic.java.model.State;
import com.rivancic.java.model.Voucher;
import java.util.Arrays;
import java.util.stream.Stream;

public class Streams {

  public static Stream<String> getLanguagesStream() {
    return Stream.of("java", "python", "c",
      "c++", "java", "python");
  }

  public static Stream<String> getNamesStream() {
    return Stream.of("Luca", "Simon", "David", "Marco", "Joel", "Michael", "Lukas", "Fabian",
      "Pascal", "Kevin", "Nicolas", "Samuel", "Jan", "Patrick", "Daniel", "Robin", "Florian");
  }

  public static Stream<Person> getPersons() {
    return Stream.of(new Person("Luca", Gender.MALE, 16), new Person("Simon", Gender.MALE, 33),
      new Person("Fabian", Gender.MALE, 23), new Person("Valentina", Gender.FEMALE, 30),
      new Person("Anita", Gender.FEMALE, 44));
  }

  public static Stream<String> getCitiesStream() {
    String[] cities = {"Seoul", "Tokyo", "Paris", "London",
        "Hong Kong", "Singapore"};
    return Arrays.stream(cities);
  }


  public static Stream<Voucher> getVoucherStream() {
    State pending = new State();
    pending.value = 1;
    pending.stateName = "PENDING";
    State active = new State();
    active.value = 0;
    active.stateName = "ACTIVE";
    State expired = new State();
    expired.value = 2;
    expired.stateName = "EXPIRED";

    Voucher voucher1 = new Voucher();
    voucher1.amount = 10;
    voucher1.name = "Spring Action";
    voucher1.state = pending;
    Voucher voucher2 = new Voucher();
    voucher2.amount = 8;
    voucher2.name = "Autumn Action";
    voucher2.state = active;
    Voucher voucher3 = new Voucher();
    voucher3.amount = 15;
    voucher3.name = "BlackFriday";
    voucher3.state = pending;
    Voucher voucher4 = new Voucher();
    voucher4.amount = 20;
    voucher4.name = "Birthday Voucher";
    voucher4.state = expired;

    return Stream.of(voucher1, voucher2, voucher3, voucher4);
  }

}
