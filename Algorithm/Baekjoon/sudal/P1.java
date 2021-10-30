package com.sudal;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class P1 {

    public static String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        String answer = "";

        for (String a : participant) {
            if (map.get(a) == null) {
                map.put(a, 1);
            } else {
                int overlap = map.get(a) + 1;
                map.put(a, overlap);
            }
        }

        for (String b : completion) {
            if (map.get(b) != null) {
                map.put(b, map.get(b) - 1);
            }
        }


        for (String a : participant) {
            if (map.get(a) == 1) {
                answer = a;
                return answer;

            }


        }
        return answer;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] a = new String[]{"leo", "kiki", "eden"};
        String[] b = new String[]{"kiki", "eden"};
        System.out.println(solution(a, b));

    }

}



