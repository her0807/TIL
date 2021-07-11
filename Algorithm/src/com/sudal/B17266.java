import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B17266 {
    static int N, M;
    static int[] A;


    public static void main(String[] args) {
        input();
        pro();

    }

    static boolean determination(int D) {
        int last=0;

        for (int i = 1; i <= N; i++) {
            if (A[i] - last <= D) {
                last = A[i]+D;
            }else
                return false;
        }
        return last>=M;
    }

    static void pro() {
        int L = 1, R = N, ans = N;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (determination(mid)) {
                ans = mid;
                R = mid - 1;

            } else {
                L = mid + 1;
            }
        }
        System.out.println(ans);
    }

    private static void input() {
        FastReader scan = new FastReader();
        M = scan.nextInt();
        N = scan.nextInt();

        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
        }
    }


}

class FastReader {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

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
