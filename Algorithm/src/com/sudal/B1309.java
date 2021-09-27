import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1309 {
    static int N;
    static long[] dp;

    public static void main(String[] args) {
        input();
        pro();
    }

    private static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        dp = new long[N + 1];

    }

    private static void pro() {
        dp[1] = 3 % 9901;
        if(N>2) {
            dp[2] = 7 % 9901;
        }
        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 2] + (dp[i - 1] * 2)) % 9901;
        }
        System.out.println(dp[N] % 9901);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
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

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
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