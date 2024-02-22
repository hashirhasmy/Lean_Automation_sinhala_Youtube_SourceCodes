package com.haashir.javainterview;

import java.util.ArrayList;
import java.util.HashSet;

public class RemoveFindDuplicateInArray {

    public static void main(String[] args) {
        int [] inputArray = {1,2,3,4,2,5,6,1,3};
//        ArrayList<Integer> duplicates = remove_find_Duplicates(inputArray);
//        System.out.println(duplicates);
        removeDuplicates(inputArray);
    }


//    public static ArrayList<Integer>  remove_find_Duplicates(int[] arr){
//        ArrayList<Integer> removeDuplicates = new ArrayList<>();
//        ArrayList<Integer> findDuplicates = new ArrayList<>();
//
//        for (int num : arr) {
//            if (!removeDuplicates.contains(num)){
//                removeDuplicates.add(num);
//            } else {
//                findDuplicates.add(num);
//            }
//        }
//        return findDuplicates;
//    }

    public static void removeDuplicates(int[] arr){
        HashSet<Integer> uniqList = new HashSet<>();
        for (int num: arr) {
            uniqList.add(num);
        }
        System.out.println("After Remove Duplicates, Showing Elements : " + uniqList);
    }




}
