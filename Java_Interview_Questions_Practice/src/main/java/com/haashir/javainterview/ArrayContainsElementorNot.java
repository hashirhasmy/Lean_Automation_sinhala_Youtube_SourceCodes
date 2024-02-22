package com.haashir.javainterview;

public class ArrayContainsElementorNot {

    //find an element present in the array or not

    int [] array = {1,2,3,4,5,3,8,3};
    int numberToFind = 3;

    boolean found = false;

    public void elementpresentotNot(){
        for (int element:array) {
            if (element==numberToFind){
                found=true;
                break;
            }
        }
        if (found){
            System.out.println("element is present");
        }else {
            System.out.println("element is not present");
        }
    }

    public static void main(String[] args) {
        ArrayContainsElementorNot arrayContainsElementorNot = new ArrayContainsElementorNot();
        arrayContainsElementorNot.elementpresentotNot();
    }



}
