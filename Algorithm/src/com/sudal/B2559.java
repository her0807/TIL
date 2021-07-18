import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2559 {

    static int N, M, R;
    static int A[];


    public static void main(String[] args) {
        input();
        pro();
    }

    private static void pro() {
        int ans, sum = 0;
        R = 1;
        for (int i = 1; i <= M; i++)
            sum += A[i];
        ans = sum;

        for (int L = M + 1; L <= N; L++) {
            sum = sum - A[L - M] + A[L];
            ans = Math.max(ans, sum);
        }
        System.out.print(ans);
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
