package com.haashir.javainterview;

import java.util.Scanner;

public class ReverseInteger {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your prefer number");
        int num = sc.nextInt();

        //1st) Using Algorithm

//            int rev = 0;
//            while(num !=0){
//                rev = rev * 10 + num%10;   //0 + 4 = 4     40+ 3 = 43     430 + 2 = 432       4320 + 1 = 4321
//                num = num/10;   //1234/10 = 123     //123/10 = 12     //12/10 = 1       //1/10 = 0
//            }
//        System.out.println(rev);

        //2) Using StringBuffer Class

        StringBuffer rev;

        StringBuffer sb = new StringBuffer(String.valueOf(num));
        rev = sb.reverse();
        System.out.println("Reverse number is :" + rev);






    }
}
