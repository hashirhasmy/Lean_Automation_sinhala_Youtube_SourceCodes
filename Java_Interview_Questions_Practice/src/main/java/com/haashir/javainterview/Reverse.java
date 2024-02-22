package com.haashir.javainterview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class Reverse{
    public static void main(String[] args) {

        String str = "ABCD";
        String rev = "";

        //1) len and chartAt

//        int len = str.length(); //4
//
//        for (int i =len-1; i>=0 ; i--){
//            rev = rev + str.charAt(i);
//        }
//        System.out.println(rev);


        //2) CharectorArray

//        char[] a = str.toCharArray();
//        int len =  a.length;
//
//        for(int i =len-1; i>=0 ; i--){
//            rev = rev + a[i];
//        }
//        System.out.println(rev);

        //3) StringBuffer
//        StringBuffer stringBuffer = new StringBuffer(str);
//        System.out.println(stringBuffer.reverse());

        //4) Using collections
        char[] a = str.toCharArray();

        List<Character> list = new ArrayList<Character>();

        for (Character character : a){
            list.add(character);
        }
        Collections.reverse(list);

        ListIterator listIterator = list.listIterator();
        while(listIterator.hasNext()){
            System.out.print(listIterator.next());
        }
    }

}
