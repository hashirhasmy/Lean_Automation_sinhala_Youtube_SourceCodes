package com.haashir.javainterview;

public class StringLeangth {
    public static void main(String[] args) {
        //Find the length of the string without length method
        String givenString = "LearnAutomation";
        System.out.println(givenString.length());

        char[] charArray =givenString.toCharArray();

        int leangth = 0;
        for (Character c : charArray){
            leangth++;
        }
        System.out.println(leangth);

    }
}
