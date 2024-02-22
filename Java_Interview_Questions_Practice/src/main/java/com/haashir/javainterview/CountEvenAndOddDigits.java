package com.haashir.javainterview;

public class CountEvenAndOddDigits {
    public static void main(String[] args) {
        //Cont number of Even and odd digits in a Given number
        //Number : 4567852
        // Odd = 3    Even = 4

        int num = 4567852;
        int event_Cont = 0;
        int odd_Count = 0;

        while(num > 0) {
            int reminder = num % 10;
            if (reminder % 2 == 0) {
                event_Cont++;
            } else  {
                odd_Count++;
            }
            num=num /10;
        }
        System.out.println("Number of even count :"+ event_Cont);
        System.out.println("Number of odd count :"+ odd_Count);

    }
}
