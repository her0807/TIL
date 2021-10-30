import java.io.*;
import java.util.*;

public class B1920 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] A;

    static void input() {
        N = scan.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
        }
    }

    static boolean bin_search(int[] A, int L, int R, int X) {

        while (L <= R) {
            int mid = (L + R) / 2;
            if (A[mid] == X) {
                return true;
            } else if (A[mid] < X) {
                L = mid + 1;
            } else
                R = mid - 1;
        }
        return false;
    }

    static void pro() {
        int M = scan.nextInt();
        Arrays.sort(A, 1, N + 1);

        for (int i = 1; i <= M; i++) {
            int X = scan.nextInt();
            sb.append(bin_search(A, 1, M, X) == true ? 1 : 0).append('\n');
        }
        System.out.println(sb);
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