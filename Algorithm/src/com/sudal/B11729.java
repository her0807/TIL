package com.sudal;


import java.io.*;


public class B11729 {
    static int count = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int a = 1, b = 2, c = 3;

        hanoi(n,a,b,c);
        bw.write(""+count);
        bw.newLine();
        bw.write(sb + "\n");   //버퍼에 있는 값 전부 출력
        bw.close();


    }

    public static void add( int from, int to) {
        sb.append(from + " " + to+"\n");
        count++;
    }

    public static void hanoi(int n, int a, int b, int c) {

        if (n == 1) {
            add(a, c);
        } else {
            hanoi(n - 1, a, c, b);
            // N-1개의 원반을 A->B 로 보조 기둥 c를 이용하여 옮긴다.
            add(a, c);
            // 제일 큰 원반을 A->C 로 옮긴다
            hanoi(n - 1, b, a, c);
            // N-1개의 원반을 B->C 로 보조 기둥 A를 이용하여 옮긴다.
        }
    }
}


