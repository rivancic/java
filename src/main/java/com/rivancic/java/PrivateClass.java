package com.rivancic.java;

public class PrivateClass {
}

/**
 * Tricky question
 * 
 * It is asking what will be the result of running this code with following command
 * 
 * java Test good morning everyone
 * 
 * The answer is Compilation Error.
 * 
 * There are 2 errors in the code.<br>
 * 1) Class is private but the main class in the file should be public and match the filename.<br>
 * 2) print line is missing semicolon.
 * 
 * Below code is commented out because its not compiling
 * 
 *
 */
/*
 * private class PrivateClass { public static void main(String args[]) {
 * System.out.println(args[1]); } }
 */
