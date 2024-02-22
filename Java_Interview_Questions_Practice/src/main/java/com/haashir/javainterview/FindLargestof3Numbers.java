package com.haashir.javainterview;

import java.util.Scanner;

public class FindLargestof3Numbers {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 1st number");
        int a = sc.nextInt();
        System.out.println("Enter 2nd number");
        int b = sc.nextInt();
        System.out.println("Enter 3rd number");
        int c = sc.nextInt();

//        if (a>b && a>c){
//            System.out.println(a + " :Largest number" );
//        } else if (b>a && b>c) {
//            System.out.println(b + " :Largest number" );
//        } else{
//            System.out.println(c + " :Largest number" );
//        }

        int largest1 = a>b ? a:b;
        int largest2 = c>largest1 ? c : largest1;
        System.out.println("LArgest value is : " + largest2);

    }
}
