/*StringBuilder Problem 1: Reverse a String Using StringBuilder
Problem:
Write a program that uses StringBuilder to reverse a given string. For example, if the input is "hello", the output
should be "olleh".
Approach:
Create a new StringBuilder object.
Append the string to the StringBuilder.
Use the reverse() method of StringBuilder to reverse the string.
Convert the StringBuilder back to a string and return it.*/
package com.week3.day4BufferFileReader.stringBuilderAndStringBuffer;

public class ReverseStringUsingStringbuilder {
    //method to reverse a string
    public static String stringReturn(String string){
        //using StringBuilder
        StringBuilder sb=new StringBuilder();

        sb.append(string);
        sb.reverse();
        return sb.toString();
    }
    //main class
    public static void main(String[] args) {
        String string="Hello";
        String stringreverse= stringReturn(string);

        System.out.println("Original String : "+string);
        System.out.println("Reverse String: "+stringreverse);
    }
}
