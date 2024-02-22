package com.haashir.javainterview;

public class CountNumberOfDigits {
    public static void main(String[] args) {

        int num = 568748;
        int count = 0;

        while(num > 0){
            num = num/10;
            count++;
        }
        System.out.println("Number of Digits :" + count);
    }
}
