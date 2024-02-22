package com.haashir.javainterview;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Find_smallest_number {

    Integer givenArray[] = {2,1,5,3,4};


    //1st aprach
    public void findSmallestValue(){
        int smallest = Integer.MAX_VALUE;

        for(int i = 0; i < givenArray.length ; i++){
            if (givenArray[i]<smallest){
                smallest = givenArray[i];
            }
        }
        System.out.println(smallest);
    }


    //2nd aproach
    public void usingArrays(){
        Arrays.sort(givenArray);
        System.out.println(givenArray[0]);
    }

    //3rd aproach
    public void usingCollections(){
        List<Integer> list =Arrays.asList(givenArray);
        Collections.sort(list);
        System.out.println(list.get(0));
    }


    public static void main(String[] args) {
                Find_smallest_number small = new Find_smallest_number();
                //small.findSmallestValue();
                //small.usingArrays();
                small.usingCollections();
    }
}
