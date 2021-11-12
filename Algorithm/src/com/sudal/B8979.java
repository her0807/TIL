import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B8979 {
    static int N, T;

    public static void main(String[] args) {
        input();
    }

    private static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        T = scan.nextInt();
        long[] score = new long[N + 1];

        for (int i = 1; i <= N; i++) {
            int F = scan.nextInt();
            int G = scan.nextInt();
            int S = scan.nextInt();
            int B = scan.nextInt();
            score[F] = G * 100000 + S * 1000 + B * 1;
        }
        int ans = 1;
        long targetScore = score[T];
        for (int i = 1; i <= N; i++) {
            if (targetScore < score[i] && T != i)
                ans++;
        }
        System.out.println(ans);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

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

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
