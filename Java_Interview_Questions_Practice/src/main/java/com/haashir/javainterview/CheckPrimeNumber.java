package com.haashir.javainterview;

public class CheckPrimeNumber {
    public static void main(String[] args) {
//        1. >1
//        2. Only should have 2 factors
        int num = 4;
        int count = 0;

        if(num > 1){

            for (int i = 1; i<= num; i++){
                if (num % i == 0)
                    count++;
            }
            if(count == 2){
                System.out.println(num +" : Prime number");
            } else {
                System.out.println(num +" : Not a Prime number");
            }
        } else {
            System.out.println(num +" : Not a Prime number");
        }
    }
}
