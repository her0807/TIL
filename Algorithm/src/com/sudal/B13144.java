import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.StringTokenizer;

public class B13144 {
    static int N;
    static int[] A, C;


    public static void main(String[] args) {
        input();
        pro();
    }

    private static void pro() {
        long S =0;
        for (int L = 1, R = 0; L <= N; L++) {
            while (R + 1 <= N && C[A[R + 1]] == 0) {
                R++;
                C[A[R]]++;
            }
            S += R - L + 1;
            C[A[L]]--;
        }
        System.out.println(S);
    }

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        A = new int[N + 1];
        C = new int[100000 + 1];
        for (int i = 1; i <= N; i++)
            A[i] = scan.nextInt();
    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {

            while (st == null || !st.hasMoreTokens()) {
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




