import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2890 {
    static int N, L, C = 0, LEN = 0;
    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        input();

        while (N-- > 0) {
            int D = scan.nextInt();
            int R = scan.nextInt();
            int G = scan.nextInt();
            for (int i = LEN; i < D; i++) {
                if (LEN == L) {
                    break;
                }
                LEN++;
                C++;
            }
            int lastTime = C % (R + G);
            if (0 <= lastTime && lastTime <= R) {
                C += R - lastTime;
            }
            if (LEN == L) {
                System.out.println(C);
                return;
            }
        }
        if (LEN < L) {
            System.out.println(C + (L - LEN));
        }
    }

    private static void input() {

        N = scan.nextInt();
        L = scan.nextInt();
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
