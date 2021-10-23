import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2460 {

    public static void main(String[] args) {
        pro();
    }

    private static void pro() {
        int in, out, total = 0, max = 0;
        FastReader scan = new FastReader();

        for (int i = 0; i < 10; i++) {
            in = scan.nextInt();
            out = scan.nextInt();
            total += out - in;
            max = Math.max(max, total);
        }
        System.out.println(max);
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
