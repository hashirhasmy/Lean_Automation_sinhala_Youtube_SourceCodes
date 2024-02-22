package com.haashir.javainterview;

public class ReverseWordInSentence {

//   How to reverse the words in a sentence

    //Learn Automation in Sinhala  --> Before
    //Sinhala in Automation Learn  --> After

    public static void main(String[] args) {

            String word = "Learn Automation in Sinhala";
            String rev = "";

            String[] splitWord = word.split(" ");
            int count = splitWord.length;
            System.out.println(count);

            for (int i = splitWord.length-1; i>=0 ; i-- ){
                rev = rev + splitWord[i]+ " ";
            }
             System.out.println(rev);




    }
}
