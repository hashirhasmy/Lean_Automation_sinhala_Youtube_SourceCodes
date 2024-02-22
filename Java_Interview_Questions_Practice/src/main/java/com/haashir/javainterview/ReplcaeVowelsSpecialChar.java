package com.haashir.javainterview;

public class ReplcaeVowelsSpecialChar {
    /*
    Apraoch 01
    1. Input = "I want to learn Automation"
    2. Convert String to Character Array
    3. Calculate the length of the String and Iterate
    4.Inside the loop check char(index) == vowel
    5. If founf vowel assign value *
    6. outside the loop iterate again print the new value

    Aprach 02
    1. Using replaceall String method
     */

    public static void main(String[] args) {

        String givenText = "I want to learn Automation";

        /*
        char[] charArray = givenText.toCharArray();

        for(int i = 0; i<givenText.length(); i++){
            if (givenText.charAt(i)=='A' || givenText.charAt(i)=='E' || givenText.charAt(i)=='I' || givenText.charAt(i)=='O' || givenText.charAt(i)=='U' ||
                    givenText.charAt(i)=='a' || givenText.charAt(i)=='e' || givenText.charAt(i)=='i' || givenText.charAt(i)=='o' || givenText.charAt(i)=='u')

                charArray[i] = '*';
        }

        for(int i = 0; i<givenText.length(); i++){
            System.out.print(charArray[i]);
        }

         */

        String replacedText = givenText.replaceAll("[AEIOUaeiou]", "*");
        System.out.println(replacedText);




    }

}
