import java.io.*;
import java.util.*;

public class B20364 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n, Q;
    static int[] estate;

    static void input() throws IOException {
        n = scan.nextInt();
        Q = scan.nextInt();
        estate = new int[n + 1];
    }

    static void pro() {

        while (Q-- > 0) {
            int x = scan.nextInt(), res = 0;
            int y = x;
            while (x > 0) {
                if (estate[x] == 1) res = x;
                x = x / 2;
            }
            estate[y] = 1;
            sb.append(res).append('\n');
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
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