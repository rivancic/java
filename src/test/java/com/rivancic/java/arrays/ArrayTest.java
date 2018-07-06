package com.rivancic.java.arrays;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class ArrayTest {

  /**
   * Assigning wrong type. Definition type for the array is double. Array of type int can't be
   * assigned to the array variable of type double. Code wont compile.
   */
  @Test
  public void assignWrongTypeToArray() {

    // double[] arr = new int[3];
    // System.out.println(arr[0]);
  }


  /**
   * Notice that the default {@link Object#toString()}} method is called when try to print the value
   * of the array. I count that as one of the java mistakes.
   * 
   * Since Java 5 you can use Arrays.toString(arr) or Arrays.deepToString(arr) for arrays within
   * arrays. Note that the Object[] version calls .toString() on each object in the array. The
   * output is even decorated in the exact way you're asking.
   * 
   * {@link Arrays#toString()}}
   */
  @Test
  public void printNullArrayElementTest() {
    boolean[] array = new boolean[3];
    System.out.println("Print array : " + array);
    System.out.println("Print array with Arrays#toString() method: " + Arrays.toString(array));
    System.out.println("Print first element: " + array[0]);

    String[][] deepArray = new String[][] {{"Janez", "Marija"}, {"Anja", "Dejan"}};
    System.out.println(Arrays.toString(deepArray));
    // output: [[Ljava.lang.String;@106d69c, [Ljava.lang.String;@52e922]
    System.out.println(Arrays.deepToString(deepArray));
  }

  @Test
  public void initialization() {
    boolean[] booleanArray = new boolean[3];
    boolean[] anonimousBooleanArray = {true, false, true};

    int[] oneDArray = new int[1];
    // int[][] twoDArrayWrongInitialization = new int[][1]; // Wrong initialization, first dimension
    // has to be specified
    int[] twoDArrayOneDimensionInitialized[] = new int[3][];
    System.out.println(Arrays.deepToString(twoDArrayOneDimensionInitialized));
    int[][] twoDArrayBothDimensionsInitialized = new int[1][1];


    // int[] assignWithDimensionAndBlock = new int[2] {1, 2}; // Isn't correct can't define
    // dimension
    // and array initializer at the same time.
    int[] assignWithBlock = new int[] {1, 2};
  }

  /**
   * 
   * Which option, if used to replace for loop definition, on execution will print ACE on to the
   * console?
   * 
   * <ul>
   * <li>int n=1; n < arr.length; n=n+1</li>
   * <li>int n=0; n < arr.length; n=n+1</li>
   * <li>int n=1; n < arr.length; n=n+2</li>
   * <li>int n=0; n < arr.length; n=n+2</li>
   * </ul>
   */
  @Test
  public void arrayAndForLoop() {
    String[] arr = {"A", "B", "C", "D", "E"};
    for (int n = 0; n < arr.length; n = 10) {
      System.out.print(arr[n]);
    }
  }

  /**
   * What will be the result of following for loop.
   * 
   * IndexOutOfBoundsException<br>
   * Compilation error<br>
   * 0, 1, 2<br>
   * 2, 1, 0
   */
  @Test
  public void printArrayItems() {
    int[] arr = {2, 1, 0};
    for (int i : arr) {
      System.out.println(arr[i]);
    }
  }

  @Test
  public void arrayTest() throws Exception {
    short[] args = new short[] {50, 50};
    args[0] = 5;
    args[1] = 10;
    System.out.println("[" + args[0] + ", " + args[1] + "]");
  }


  /**
   * Enhanced for loop can be used with array parameter.
   * 
   * @throws Exception
   */
  @Test
  public void changingElements() throws Exception {
    String[] arr = {"A", "B", "C", "D"};
    arr[0] = arr[1];
    arr[1] = "E";
    for (String s : arr) {
      System.out.print(s + " ");
    }
    assertEquals("B", arr[0]);
    assertEquals("E", arr[1]);
    assertEquals("C", arr[2]);
    assertEquals("D", arr[3]);
  }
}
