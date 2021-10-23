import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10818 {
    static int N, MAX = Integer.MIN_VALUE, MIN = Integer.MAX_VALUE;
    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        pro();
    }

    private static void pro() {
        N = scan.nextInt();

        while (N-- > 0) {
            int temp = scan.nextInt();
            MAX = Integer.max(temp, MAX);
            MIN = Integer.min(MIN, temp);
        }
        System.out.println(MIN + " " + MAX);

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
