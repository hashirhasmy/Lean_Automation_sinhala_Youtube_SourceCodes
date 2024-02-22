package com.haashir.javainterview;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {

        int a[] = {5, 1, 4, 2, 8};

        int n = a.length;    //n=5

        System.out.println("Before sorting : " + Arrays.toString(a));

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }

        System.out.println("After sorting :" + Arrays.toString(a));
    }
}
