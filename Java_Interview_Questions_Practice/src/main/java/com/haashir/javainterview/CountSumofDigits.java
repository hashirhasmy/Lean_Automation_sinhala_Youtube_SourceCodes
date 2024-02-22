package com.haashir.javainterview;

public class CountSumofDigits {
    public static void main(String[] args) {
        //Count sum of Digits in a Number

        int num = 1234;
        int sum = 0;

        while(num > 0){
            sum = sum + num % 10;  //4 + 3 + 2 + 1
            num= num/10;  //123   12  1  0
        }
        System.out.println("Sum of digit in the given number :" + sum);
    }
}
