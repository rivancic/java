package com.rivancic.java.genericscollections;

public class GenericDeclarationTest {
}

class GenericExtends<T extends String> {

}

/**
 * Won't compile. Generic class Type has to be a subclass of the template.
 */
// class GenericSuper<T super String> {

// }
