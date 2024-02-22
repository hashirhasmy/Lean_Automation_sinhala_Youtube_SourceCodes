package com.haashir.javainterview;

import java.util.Locale;

public class VowelsCount_in_GivenString {
    //Find the number of vowels in the given string//

    //input = "Learn Automation"
    //Output = 8

    //First asume vowels count is 0
    //Change the String to Uniform case
    //Take the length of the String
    //Iterate the character untill the length of the String
    //Inside the loop, check if the char is any of the vowel character.
    // If so increment the count by +1

    public static void main(String[] args) {
        String input = "Learn Automation";
        int vowelCount = 0;

        input = input.toLowerCase();

        for(int i = 0; i<input.length(); i++){
            if (input.charAt(i)=='a' ||  input.charAt(i)=='e' || input.charAt(i)=='i' || input.charAt(i)=='o' || input.charAt(i)=='u' )
                vowelCount++;
        }
        System.out.println("Mentioned sentence has " + vowelCount + " vowel(s)");
    }
}
