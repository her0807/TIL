package com.sudal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class B11399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        int sum=0;
        num= sc.nextInt();
        int arr[] = new int[num];

        for(int i =0; i<num; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        for (int i = 0; i < num; i++) {
            for (int j = i; j >= 0; j--) {
                sum += arr[j];
            }
        }
        System.out.println(sum);
    }
}
