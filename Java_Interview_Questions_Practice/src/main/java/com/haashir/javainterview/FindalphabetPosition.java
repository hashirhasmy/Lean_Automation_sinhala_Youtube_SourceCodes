package com.haashir.javainterview;

import java.util.Scanner;

public class FindalphabetPosition {
    public static void main(String[] args) {
        //find the position of an English alphabet
        //ASCII  => a - 97 , A - 65

        Scanner scanner = new Scanner(System.in);
        System.out.println("Provide a English Letter :");

        char letter = scanner.next().charAt(0);
        letter = Character.toLowerCase(letter);

        int ascivalue = (int)letter;
        System.out.println(ascivalue);

        int position = ascivalue - 96;
        System.out.println(position);






    }
}
