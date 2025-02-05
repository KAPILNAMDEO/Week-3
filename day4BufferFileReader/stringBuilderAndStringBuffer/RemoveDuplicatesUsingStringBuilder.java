package com.week3.day4BufferFileReader.stringBuilderAndStringBuffer;

import java.util.HashSet;

public class RemoveDuplicatesUsingStringBuilder {
    //method to remove duplicate
    public static String removeDuplicate(String string){
        //Initialize StringBuilder
        StringBuilder sb=new StringBuilder();
        //HashSet initialize to avoid duplicates elements in string
        HashSet<Character> seen=new HashSet<>();

        for(char character : string.toCharArray() ){
            //if seen does not contains elements means character  first time occur
            if(!seen.contains(character)){
                //add character in sb
                sb.append(character);
                //add character in hashmap
                seen.add(character);
            }
        }
        return sb.toString();

    }
    public static void main(String[] args) {
        String string="Hello welcome to our program";
        String stringDuplicateRemove=removeDuplicate(string);

        System.out.println("Given String: "+string);
        System.out.println("String After remover of Duplicate: "+stringDuplicateRemove);

    }
}
