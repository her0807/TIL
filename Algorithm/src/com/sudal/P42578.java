import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class P42578 {
    public static void main(String[] args) {
        String[][] arr = new String[][]{{"노란모자", "모자"}, {"두건", "모자"}, {"흰바지", "선구"}};
        System.out.println(solution(arr));
    }


    public static int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> list = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            list.put(clothes[i][1], list.getOrDefault(clothes[i][1], 1) + 1);
            System.out.println(clothes[i][1]);
        }

        for (Iterator<Integer> i = list.values().iterator(); i.hasNext(); ) {
            int a = i.next();

                answer *= a;
        }
        return answer - 1;
    }

}
