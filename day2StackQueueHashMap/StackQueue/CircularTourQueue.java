package com.week3.day2StackQueueHashMap;

import java.util.LinkedList;
import java.util.Queue;

public class CircularTourQueue {
    //method to find start index
    public static int findStartIndex(int petrol[],int distance[],int startIndex){
        int n=petrol.length;
        //initilaize start index
        Queue<Integer> queue=new LinkedList<>();
        int totalsurplus=0,currentsurplus=0;
        startIndex=0;

        for (int i = 0; i < n; i++) {
            //find netpetrol by diff b/w petrol and distnace
            int netPetrol=petrol[i]-distance[i];
            //total surplus find
            totalsurplus+=netPetrol;
            queue.add(i);
            currentsurplus+=netPetrol;
            //use while loop until currentsurplus less than zero and until queue is empty
            while(currentsurplus<0 && !queue.isEmpty()){
                startIndex= queue.poll()+1;
                currentsurplus-=petrol[startIndex-1]-distance[startIndex-1];
            }
        }
        return  (totalsurplus >= 0) ? startIndex : -1;
    }
    //main method
    public static void main(String[] args) {
        int petrol[]={4,6,7,4};
        int distance[]={6,5,3,5};
        int startIndex=0;
        int startIndexofpetrol=findStartIndex(petrol,distance,startIndex);

        if (startIndex != -1) {
            System.out.println("The circular tour can start from pump index: " + startIndexofpetrol);
        } else {
            System.out.println("No possible circular tour.");
        }

    }
}
