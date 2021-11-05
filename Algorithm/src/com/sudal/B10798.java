import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10798 {
    static String[] str = new String[5];
    static int max = 0;

    public static void main(String[] args) {
        input();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < max; i++) {
            for (int j = 0; j < 5; j++) {
                if (str[j].length() - 1 < i)
                    continue;
                sb.append(str[j].charAt(i));
            }
        }
        System.out.println(sb);
    }

    private static void input() {
        FastReader scan = new FastReader();

        for (int i = 0; i < 5; i++) {
            str[i] = scan.next();
            max = Math.max(str[i].length(), max);
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
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

