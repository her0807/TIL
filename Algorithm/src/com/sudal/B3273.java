import java.io.*;
import java.util.*;

public class B3273 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, X;
    static int[] A;

    static void input() {
        N = scan.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
        }
    }

    static boolean bin_search(int[] A, int L, int R, int Target) {

        while (L <= R) {
            int mid = (L + R) / 2;
            int sum = (A[mid] + Target);
            if (sum == X) {
                return true;
            } else if (sum < X) {
                L = mid + 1;
            } else
                R = mid - 1;
        }
        return false;
    }

    static void pro() {
        X = scan.nextInt();
        int count = 0;
        Arrays.sort(A, 1, N + 1);

        for (int i = 1; i <= N; i++) {

            if (bin_search(A, i + 1, N, A[i]))
                count++;
        }
        System.out.println(count);
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