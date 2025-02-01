package com.week3.day3Sorting;

import java.util.Arrays;

public class BubbleSort {
    static void sortStudentMarks(int studentMarks[],int n){
      int i=0,j=0,temp;
      boolean swapped=false;
        for ( i = 0; i <n-1 ; i++) {
           for (j=0;j<n-i-1;j++){
               //compares adjacent elements , if they are sorted then no change otherwise swap the elements.
               if(studentMarks[j]>studentMarks[j+1]){
                  temp=studentMarks[j];
                  studentMarks[j]=studentMarks[j+1];
                  studentMarks[j+1]=temp;
                  swapped=true;
               }
           }
           if(!swapped){
               break;
           }
        }

    }
    public static void main(String[] args) {
        int studentMarks[]={45,68,53,78,86};
        int n=studentMarks.length;
        //call method to sort
        sortStudentMarks(studentMarks,n);
        //use Arrays.toString to convert array into String
        System.out.println("Students Sorted Marks are: "+Arrays.toString(studentMarks));
    }

}
