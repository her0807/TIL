import java.io.*;
import java.util.*;

public class B2343 {
    static FastReader scan = new FastReader();

    static int N, C;
    static int[] A;

    static void input() {
        N = scan.nextInt();
        C = scan.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
        }
    }

    static boolean determination(int D) {

        int cnt = 1, sum = 0;
        for (int i = 1; i <= N; i++) {
            if (sum + A[i] <= D) {
                sum += A[i];
            } else {
                cnt++;
                sum = A[i];
            }

        }
        return cnt > C;
    }

    static void pro() {

        int L = 1, R = 1000000000, ans = 0;
        for (int i = 1; i <= N; i++) L = Math.max(L, A[i]);  // 적어도 제일 긴 녹화본의 길이 만큼은 필요하다!
        while (L <= R) {

            int mid = (L + R) / 2;

            if (determination(mid)) {
                L = mid + 1;

            } else {
                ans = mid;
                R = mid - 1;
            }
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