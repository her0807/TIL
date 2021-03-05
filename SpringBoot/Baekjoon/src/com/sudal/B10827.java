package com.sudal;

import java.util.Scanner;

public class B10827 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int temp= s.nextInt();
        System.out.println(Factorial(temp));

    }

    public static int Factorial(int temp) {
        if (temp > 0) {
            return temp * Factorial(temp - 1);
        } else {
            return 1;

        }
    }

}
