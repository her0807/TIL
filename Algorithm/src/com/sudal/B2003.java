import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2003 {
    static int N, M;
    static int[] A;

    public static void main(String[] args) {
        input();
        pro();
    }

    static void pro() {
        int R = 0, sum = 0, ans = 0;
        for (int L = 1; L <= N; L++) {
            sum -= A[L - 1];

            while (R + 1 <= N && sum < M)
                sum += A[++R];
            if (sum == M) {
                ans++;

            }
        }
        System.out.println(ans);
    }

    private static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
