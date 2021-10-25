import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14719 {
    static int N, M, L = 0, R = 0, ANS = 0;
    static int[] arr;

    public static void main(String[] args) {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        arr = new int[M];

        for (int i = 0; i < M; i++)
            arr[i] = scan.nextInt();


        for (int i = 1; i < M - 1; i++) {
            L = R = 0;

            for (int j = 0; j < i; j++) {
                L = Math.max(arr[j], L);
            }

            for (int j = i + 1; j < M; j++) {
                R = Math.max(arr[j], R);
            }
            if (arr[i] < L && arr[i] < R) {
                ANS += Math.min(L, R) - arr[i];
            }
        }

        System.out.println(ANS);
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
