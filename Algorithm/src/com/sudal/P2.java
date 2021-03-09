package com.sudal;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P2 {

    public static boolean solution(String[] phone_book) {

            boolean answer = true;
            int min = phone_book[0].length();

            Map<String, Integer> map = new HashMap<>();

            for(int i = 0; i < phone_book.length; i++) {
                if(min>phone_book[i].length())
                    min = phone_book[i].length();
                map.put(phone_book[i], i);
            }


            for(int i = 0; i < phone_book.length; i++) {
                for(int j = 0; j < phone_book[i].length(); j++) {
                    if(map.containsKey(phone_book[i].substring(0,j))) {
                        answer = false;
                        return answer;
                    }
                }
            }




            return answer;
        }



//
//        for(String a : phone_book){
//            map.put(a,a.hashCode());
//        }
//
//
//        for (int i=0; i<phone_book.length; i++) {
//            for (int j = i+1; j < phone_book.length; j++) {
//                if (phone_book[j].length() >= phone_book[i].length()) {
//                    System.out.println(phone_book[j].substring(0, phone_book[i].length()));
//                    if (map.containsValue(phone_book[j].substring(0, phone_book[i].length()).hashCode()))
//                        return false;
//                }
//            }
//        }
//        return true;


//    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] a = new String[]{"119", "97674223", "1195524421"};
        String[] b = new String[]{"12", "567", "88"};
        String[] c = new String[]{"123", "12", "1234" ,"9935", "567", "88"};
        System.out.println(solution(a));

    }

}


