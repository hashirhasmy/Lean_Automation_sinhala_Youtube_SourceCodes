package com.haashir.javainterview;

public class Swapping2Numbers {
    public static void main(String[] args) {

            int a = 10;
            int b = 20;

        System.out.println("Before Swapping values are :" + a + ","+b);

        //1) using third variable
//        int c = a; //10
//        a = b; //20
//        b= c; //10

        //2)Use + and - without using third variable

//        a = a +b; //10+20=30
//        b = a - b; //30 - 20 =10
//        a = a - b; //30 - 10 = 20

        //3) Use * and / Without using third variable

        a = a * b; //10 * 20 = 200
        b = a/b;  //200 / 20 = 10
        a = a/b; // 200 / 10 = 20

        System.out.println("After Swapping values are :" + a + ","+b);


    }
}
