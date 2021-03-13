package com.sudal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Stack;

public class B1874 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());


        int start = 0;
        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(br.readLine());
            if (now > start) {
                for (int j = start+1; j <= now; j++) {
                    sb.append("+").append("\n");
                    stack.push(j);
                }
                start = now;
            } else if (stack.peek() != now) {
                System.out.println(stack.peek());
                System.out.println(now);
                System.out.println("NO");
                return;
            }
            stack.pop();
            sb.append("-").append("\n");


        }
        System.out.println(sb+"\n");

        br.close();
    }

}
