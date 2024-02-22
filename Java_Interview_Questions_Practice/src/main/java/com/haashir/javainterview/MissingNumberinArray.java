package com.haashir.javainterview;

public class MissingNumberinArray {
    public static void main(String[] args) {
        //Array should not have Duplicates
        //Sorted order not mandatory
        //Value should in a Range

        int a[] = {1,2,4,5};

        //1+2+4+5 = 12 sum1
        //1+2+3+4+5 = 15 sum2
        //sum2 - sum1 = missing number


        int sum1 = 0;
        for (int i = 0; i<a.length; i++ ){
            sum1 = sum1 + a[i];
        }
        System.out.println("Sum of elements in Given Array :" + sum1);

        int sum2 = 0;
        for (int i=0; i<=5; i++){
            sum2 = sum2 + i;
        }
        System.out.println("sum of range of elemnts in Array : "+ sum2);

        System.out.println("Missing number is :"+ (sum2-sum1));

    }
}
