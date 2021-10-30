import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2501 {

    static int N, K;
    static int[] arr;

    public static void main(String[] args) {
        input();
        pro();
    }

    private static void pro() {
        int count = 1;
        for (int i = 1; i < N; i++) {
            if (N % i == 0) {
                arr[count++] = i;
            }
        }
        System.out.println(arr[K]);
    }

    private static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        K = scan.nextInt();

        arr = new int[N + 1];
    }

    static class FastReader {
        StringTokenizer st;
        BufferedReader br;

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
