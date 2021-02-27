package com.sudal;

import java.io.*;


public class B2447 {



    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String[][] starArr = new String[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                starArr[i][j] = "*";
            }
        }

        star(starArr, 0, 0, n);
        for (String[] st : starArr) {
            for (String s : st) {
                sb.append(s);
            }
            sb.append("\n");
        }


        bw.write(sb + "\n");   //버퍼에 있는 값 전부 출력
        bw.close();


    }


    public static void star(String[][] arr, int x, int y, int n) {
        if (n == 1) {
            arr[x][y] = "*";
            return;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!(i == 1 && j == 1))
                    star(arr, x + i * (n / 3), y + j * (n / 3), n / 3);
            }
        }
    }
}

