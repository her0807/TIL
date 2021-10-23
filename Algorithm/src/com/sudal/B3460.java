import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B3460 {
    static int N, T;
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        input();
        pro();
    }

    private static void pro() {
        while (N-- > 0) {
            T = scan.nextInt();
            int index = 0;

            while (T > 0) {
                if (T % 2 == 1)
                    sb.append(index + " ");
                T /= 2;
                index++;
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void input() {

        N = scan.nextInt();
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
