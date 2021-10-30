package com.sudal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

class B15650 {
    public static int[] arr;
    public static boolean[] visit;
    public static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        visit = new boolean[N];
        dfs(N, M, 0,0);
        System.out.println(sb);
    }




    public static void dfs(int N, int M, int depth ,int a) {
        if (depth == M) {
            for (int val : arr) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }
        for (int i=a; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = i+1;
                dfs(N, M, (depth) + 1,i);
                visit[i] = false;


            }
        }

    }
}
