package com.week3.day3Sorting;

import java.util.Arrays;

public class BookStore {
    static void merge(double bookPrices[],int left,int mid,int right){
        int  size1=mid-left+1;
        int size2=right-mid;
        //initialize left and right subarray
        double leftArray[]=new double[size1];
        double rightArray[]=new double[size2];


        //add leftsubArrays values
        for (int i = 0; i <size1 ; i++) {
            leftArray[i]=bookPrices[left+i];
        }

        //add leftsubArrays values
        for (int j = 0; j <size2 ; j++) {
            rightArray[j]=bookPrices[mid+1+j];
        }

        int i=0,j=0;
        int k=left;

        //use while to swap elements if they are not sorted
        while (i <size1 && j <size1){
            if(leftArray[i]<=rightArray[j]){
                bookPrices[k]=leftArray[i];
                i++;
            }
            else {
                bookPrices[k]=rightArray[j];
                j++;
            }
            k++;
        }

        while (i<size1){
            bookPrices[k]=leftArray[i];
            i++;
            k++;
        }

        while (j<size2){
            bookPrices[k]=rightArray[j];
            j++;
            k++;
        }

    }
    static void sortBookPrice(double bookPrices[],int left,int right){
        if(left<right){
            int mid=left+(right-left)/2;
           // divide array into subarrays like: array in left to mid and mid+1 to right array,until the array reach each single element.
            // After then sort both array.
            sortBookPrice(bookPrices,left,mid);
            sortBookPrice(bookPrices,mid+1,right);


            //combine subArrays merge sort into
            merge(bookPrices,left,mid,right);//call method to merge subArray
        }

    }
    //main class
    public static void main(String[] args) {
        double bookPrices[]={15,62,42,34};
        int size=bookPrices.length-1;
        //call to sort the list
        sortBookPrice(bookPrices,0,size);
        System.out.println("Books prices are sorted by Merge sort: "+ Arrays.toString(bookPrices));

    }
}
