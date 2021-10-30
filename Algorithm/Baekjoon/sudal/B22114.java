import java.io.*;
import java.util.*;

public class B22114 {
    static FastReader scan = new FastReader();

    static int N, M;
    static int[] A;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        A = new int[N];
        for (int i = 1; i < N; i++) {
            A[i] = scan.nextInt();
        }
    }

    static void pro() {
        int ans = Integer.MIN_VALUE;

        for (int j = 1; j < N; j++) {
            int jump = 0;
            int cunt = 1;

            for (int i = j; i < N; i++) {
                if (A[i] <= M)
                    cunt++;
                else if (A[i] > M && jump == 0) {
                    jump++;
                    cunt++;
                } else
                    break;
            }
            ans = Math.max(ans, cunt);

        }
        System.out.print(ans);
    }

    public static void main(String[] args) {
        input();
        pro();
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
    }
}