package com.haashir.javainterview;

import java.util.Scanner;

public class Print_Triangle {
    public static void main(String[] args) {
        //1) st using *
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter the rows/colum that you want");
//        int numberLines = sc.nextInt();
//
//        int row,column = 0;
//
//        for(row=0; row<numberLines; row++){
//            for (column = 0; column<=row; column++){
//                System.out.print("* ");
//            }
//            System.out.println();
//        }


        //2) incrementing number
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Enter the rows/colum that you want");
        int limit = sc1.nextInt();
        int starting_number = 1;

        int row1,column1;

        for (row1=0; row1<limit; row1++){
            for (column1=0; column1<=row1; column1++){
                System.out.print(starting_number);
                starting_number++;
            }
            System.out.println();
        }



    }
}
