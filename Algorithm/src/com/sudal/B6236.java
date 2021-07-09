import java.io.*;
import java.util.*;

public class B6236 {
    static FastReader scan = new FastReader();

    static int N, M;
    static int[] A;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
        }
    }


    static boolean determination(int withdrawl) {
        int cnt = 1, sum = withdrawl;
        for (int i = 1; i <= N; i++) {
            if (sum - A[i] >= 0) {
                sum -= A[i];
            } else {
                sum = withdrawl - A[i];
                cnt++;
            }
        }
        return cnt <= M;
    }

    static void pro() {
        int L = A[1], R = 1000000000, ans = 0;
        for (int i = 1; i <= N; i++)
            L = Math.max(L, A[i]);
        while (L <= R) {
            int mid = (L + R) / 2;
            if (determination(mid)) {
                R = mid - 1;
                ans = mid;
            } else
                L = mid + 1;
        }
        System.out.println(ans);
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