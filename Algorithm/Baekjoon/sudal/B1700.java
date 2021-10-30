giimport java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class B1700 {
    static int N, K, C = 0, ANS = 0;
    static int[] stack;
    static HashSet<Integer> arr;

    public static void main(String[] args) {
        input();
        System.out.println(ANS);
    }

    private static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        K = scan.nextInt();

        stack = new int[K];

        arr = new HashSet<>();
        for (int i = 0; i < K; i++) {
            stack[i] = scan.nextInt();
            if (arr.size() < N) {
                if (!arr.contains(stack[i])) {
                    arr.add(stack[i]);
                }
            }
        }

        for (int j = arr.size(); j < K; j++) {
            int checkTarget = stack[j];
            if (arr.contains(checkTarget))
                continue;
            HashSet<Integer> copyTap = new HashSet<>();

            for (Integer i : arr) {
                copyTap.add(i);
            }

            for (int k = j + 1; k < K; k++) {
                if (copyTap.size() == 1) break;
                if (copyTap.contains(stack[k])) {
                    copyTap.remove(stack[k]);
                }
            }

            int rest = 0;
            for (int i : copyTap) {
                rest = i;
                break;
            }

            arr.remove(rest);
            arr.add(stack[j]);
            ANS++;

        }
    }

    static class FastReader {
        StringTokenizer st;
        BufferedReader br;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}