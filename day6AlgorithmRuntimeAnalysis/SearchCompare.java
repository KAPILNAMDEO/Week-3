package com.week3.day6AlgorithmRuntimeAnalysis;



import java.util.Arrays;
import java.util.Random;

public class SearchCompare {
    // linear search method to find target
    static int linearSearch(int arr[],int target){
        for (int i = 0; i <arr.length ; i++) {
            if(arr[i]==target){
                return i;
            }
        }
        return -1;

    }
    //binary search method to find target
    static int binarySearch(int arr[],int target){
        int left=0,right = arr.length-1;


        while(left<=right){
            int mid =left+(right-left)/2;
            if(arr[mid]==target){
                return mid;
            } else if (arr[mid]<target) {
                left=mid+1;
            }
            else {
                right=mid-1;
            }
        }
        return -1;

    }
    public static void main(String[] args) {
        int []dataSetSizes={1000,10000,100000};
        Random random=new Random();
        for(int n: dataSetSizes){
            int []data=new int[n];
            for (int i = 0; i <n ; i++) {
                //random values upto 10*n
                data[i]= random.nextInt(n*10);
            }
            //choose random number for target element
            int target=data[random.nextInt(n)];

            //measure linear search time
            long startTime=System.nanoTime();
            int linearResult=linearSearch(data,target);
            long linearTime=System.nanoTime()-startTime;

            //sort data to find target through binary search
            Arrays.sort(data);


            //measure linear search time
            startTime=System.nanoTime();
            int binaryResult=binarySearch(data,target);
            long binaryTime=System.nanoTime()-startTime;

            //display result of linear search time  and binary search time
            System.out.println("DataSet Size: "+n);
            System.out.println("Linear Search Time: " + linearTime / 1_000_000.0 + " ms");
            System.out.println("Binary Search Time: " + binaryTime / 1_000_000.0 + " ms");
            System.out.println("---------------------------------");
            System.out.println();

        }
    }
}
