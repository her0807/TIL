package com.sudal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11047 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int price = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(caculate(arr, n - 1, price, 0));


    }

    public static int caculate(int[] a, int i, int p, int c) {
        if (p == 0)
            return c;

        if (a[i] > p && i > -1)
            return caculate(a, i - 1, p, c);

        if (i > -1)
            return caculate(a, i - 1, p % a[i], c + (p / a[i]));

        return 0;
    }
}


