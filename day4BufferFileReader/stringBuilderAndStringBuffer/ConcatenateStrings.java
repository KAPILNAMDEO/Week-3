package com.week3.day4BufferFileReader.stringBuilderAndStringBuffer;

public class ConcatenateStrings {
    public static String concateString(String strings[]){
        //method to concate words
        StringBuffer stringBuffer=new StringBuffer();
        for(String string: strings ){
            //append word in stringbuilder
            stringBuffer.append(string);
        }
        return stringBuffer.toString();
    }
    //main method
    public static void main(String[] args) {
        String []words={"Hello ","Members ","Nice ","to ","meet ","you ","all"};
        String result=concateString(words);

        System.out.println("Concatenated Words are : "+result);
    }
}
