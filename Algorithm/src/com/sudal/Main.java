package com.sudal;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static boolean solution(String[] phone_book) {

        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 0; j < phone_book.length; j++) {
                if (phone_book[j].contains(phone_book[i]) && i!=j)
                    return false;
            }

        }
        return true;
    }




    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] a = new String[]{"119", "97674223", "5524421"};
        String[] b = new String[]{"12","123","1235","567","88"};
        System.out.println(solution(a));

    }

}



