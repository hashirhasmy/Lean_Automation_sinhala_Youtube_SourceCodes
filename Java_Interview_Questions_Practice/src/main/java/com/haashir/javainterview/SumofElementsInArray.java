package com.haashir.javainterview;

public class SumofElementsInArray {
    public static void main(String[] args) {
        int a[] = {3,1,5,4,6};
        int sum = 0;

//        for (int i =0; i<=a.length-1; i++){    //a.length-1 = 4
//            sum = sum + a[i];   //3+1+5+4+6
//        }

        //Enhanced for loop
        for (int value:a) {
            sum = sum + value;
        }
        System.out.println("Sum of Array Element : "+ sum);
    }
}
