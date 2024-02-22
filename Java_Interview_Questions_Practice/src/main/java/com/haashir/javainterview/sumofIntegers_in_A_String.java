package com.haashir.javainterview;

public class sumofIntegers_in_A_String {
    //Find Numbers from String And Calculate sum Of Them//
    //input = "LearnAutomation123";
    //output = 1 + 2 + 3 = 6
    //Steps
    //1. Assume the total equal to 0
    //2. Take length of string and iterate
    //3. inside loop fetch each char in a variable
    //4. verify fetched char is a numeric value using isDigit()
    //5. if it is digit get the numeric value and add the valu in to total
    public static void main(String[] args) {
        String input = "LearnAutomation123";
        int total = 0;

        for (int i = 0; i<input.length(); i++){
             char character = input.charAt(i);

             if (Character.isDigit(character)){
                 total = total + Character.getNumericValue(character);
             }
        }
        System.out.println(total);
    }
}
