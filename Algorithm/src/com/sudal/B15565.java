import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15565 {
    static int N, K, C = 0;
    static int[] A;

    public static void main(String[] args) {
        input();
        pro();
    }

    private static void pro() {
        int ans = -1;
        int R = 0;

        for (int L = 1; L <= N; L++) {

            while (R < N && C < K) {
                R++;
                if (A[R] == 1)
                    C++;
            }
            if (C == K) {
                if (ans == -1)
                    ans = R - L + 1;
                ans = Math.min(ans, R - L + 1);
            }

            if (A[L] == 1)
                C--;
        }
        System.out.println(ans);

    }


    private static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        K = scan.nextInt();
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
