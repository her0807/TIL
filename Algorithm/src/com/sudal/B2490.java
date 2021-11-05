import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2490 {
    static String[] list = new String[3];

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        input();
        for (int i = 0; i < 3; i++) {
            int count = 0;
            for (int j = 0; j < 7; j += 2) {
                if (list[i].charAt(j) == '0') {
                    count++;

                }
            }
            sb.append(count!=0? (char) (count + 64) : (char) (count + 69)).append('\n');
        }
        System.out.println(sb);
    }

    private static void input() {
        FastReader scan = new FastReader();

        for (int i = 0; i < 3; i++)
            list[i] = scan.nextLine();
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

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
