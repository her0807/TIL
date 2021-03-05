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

        for (int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(caculate(arr, n-1, price, 0));


    }

    public static int caculate(int[] arr, int index, int price, int coin) {
        if (price == 0)
            return coin;

        if (arr[index] > price && index> -1)
            return caculate(arr, index - 1, price, coin);

        if(index>-1)
            return caculate(arr, index - 1, price%arr[index], coin+(price/arr[index]) );

     return 0;
    }
}


