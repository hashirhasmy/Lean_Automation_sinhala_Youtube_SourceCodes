package com.haashir.javainterview;

public class PrintEvenOddfromArry {
    public static void main(String[] args) {
        //Print Even & Odd Numbers from Given Array

        int a[] = {1, 2, 3, 4, 5, 6};

        System.out.println("Print Even Numbers");

        for (int even : a) {
            if (even % 2 == 0)
                System.out.println(even);
        }

//        for (int i=0; i<a.length; i++){
//            if (a[i]%2 == 0)
//                System.out.println(a[i]);
//        }

        System.out.println("Print Odd Numbers");

        for (int odd : a) {
            if (odd % 2 != 0)
                System.out.println(odd);
        }

//        for (int i=0; i<a.length; i++){
//            if (a[i]%2 != 0)
//                System.out.println(a[i]);
//        }


    }
}
