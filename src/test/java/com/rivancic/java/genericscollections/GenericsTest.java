package com.rivancic.java.genericscollections;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * Generics are type parameters for code.
 * 
 * @author rivancic
 *
 */
public class GenericsTest {

  /**
   * One can not use primitive types as generic types. Compilation error will be thrown. Syntax
   * error, insert "Dimensions" to complete ReferenceType
   */
  @Test
  public void testname() {
    // List<int> primitiveIntList = new ArrayList<>();
  }


  /**
   * Diamond operator was introduced with the Java version 7. This way we can omit type parameters
   * in initialization. The compiler will infer needed generic type.
   */
  @Test
  public void listInitialization() {
    List<String> list = new ArrayList<String>();
    List<String> listWithDiamondOperator = new ArrayList<>();
  }

  /**
   * Type specification in generics is just for the compilation time. To be compatible with the
   * legacy raw types the actual of objects type is Object. Compiled code uses Object as a class not T.
   * At the end compiler is adding casts.
   * 
   * In below case the class will not be 
   * <code><pre>class java.util.ArrayList<Integer></pre></code> but just <code>class java.util.ArrayList</code>
   */
  @Test
  public void typeErasure() {
    
    List<Integer> integerList = new ArrayList<>();
    List<String> stringList = new ArrayList<>();
    System.out.println("Integer list type is: " + integerList.getClass());
    System.out.println("String list type is: " + stringList.getClass());
    

  }
  
  @Test
  public void rawGenericList() throws Exception {
    List list = new ArrayList();
    list.add("7");
    list.add(7);
    // for(String item : list) { Compilation error because list is of raw type
    for(Object item : list) {
      System.out.println(item);
    }
  }
}
