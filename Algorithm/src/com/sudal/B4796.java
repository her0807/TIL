package com.sudal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B4796 {
    static int L, P, V;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int cnt = 1;

        while (true) {
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());
            int holiday = 0;
            if (L == 0 && P == 0 && V == 0) {
                break;
            }
            int value = V / P;
            int leftDay = V - value * P;
            holiday += value * L;
            if (leftDay > L) {
                holiday += L;
            }
            if (leftDay <= L) {
                holiday += leftDay;
            }
            System.out.println("Case " + cnt + ": " + holiday);
            cnt++;
        }
    }
}
