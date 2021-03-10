package com.sudal;

import java.io.*;

public class B1003 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine());
            int[] call0 = new int[tmp + 1];
            int[] call1 = new int[tmp + 1];

            if (tmp >= 0) {
                call0[0] = 1;
                call1[0] = 0;
            }
            if (tmp >= 1) {
                call0[1] = 0;
                call1[1] = 1;
            }

            for (int j = 2; j <= tmp; j++) {
                call0[j] = call1[j - 1];
                call1[j] = call0[j - 1] + call1[j - 1];
            }

            sb.append(call0[tmp] + " " + call1[tmp] + "\n");

        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
