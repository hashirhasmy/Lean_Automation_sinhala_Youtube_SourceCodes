package com.haashir.javainterview;

import java.util.Locale;

public class CountlettercountinString {

    public static void main(String[] args) {
        //1)Using Iteration
//        String input = "MohamedHashir";
//        char toFind = 'a';
//
//        int count = 0;
//
//        input = input.toLowerCase();
//
//        for (int i = 0; i<input.length(); i++){
//            if (input.charAt(i) == toFind){
//                count = count + 1;
//            }
//        }
//        System.out.println(toFind + " is present "+ count + " Number of times");

        //2) using without Iteration

        String input = "MohamedHashir";
        char toFind = 'a';

        input = input.toUpperCase();

        String chartoFind = Character.toString(toFind).toUpperCase();

        int actualleangth = input.length();
        System.out.println(actualleangth);

        input = input.replace(chartoFind, "");

        int leangthafterReplacing = input.length();
        System.out.println(leangthafterReplacing);

        System.out.println(actualleangth-leangthafterReplacing);



    }
}
