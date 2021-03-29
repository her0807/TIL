package com.sudal;

import java.util.Scanner;

public class B19947 {

    static int sum=0;


    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int y = sc.nextInt();

        search(m, y);

        System.out.println(sum);
    }

    public static void search(int m, int y) {
        if (y == 0) {
            sum = Math.max(sum, m);
           return;
        }

        if (y - 5 >= 0) {
            search((int) (m * 1.35), y - 5);
        }

        if (y - 3 >= 0) {
            search((int) (m * 1.2), y - 3);

        }
        if (y - 1 >= 0) {
            search((int) (m * 1.05), y - 1);
        }

    }
}
