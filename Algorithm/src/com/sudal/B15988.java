import java.io.*;
import java.util.*;

public class B15988 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static long[] Dy;

    static void preprocess() {
        Dy = new long[10000001];

        Dy[1] = 1; // 1
        Dy[2] = 2; // 1+1 , 2
        Dy[3] = 2; // 1+1+1, 1+2, 2+1, 3;
        Dy[4] = 3;
        Dy[5] = 3;
        Dy[6] = 6;
        // 초기값 구하기
        /* TODO */

        // 점화식을 토대로 Dy 배열 채우기
        /* TODO */

        for (int i = 7; i <Dy.length; i++)
            Dy[i] = (Dy[i - 2] + Dy[i - 4] + Dy[i - 6]) % 1000000009;

    }

    static void pro() {
        int T = scan.nextInt();
        for (int tt = 1; tt <= T; tt++) {
            int N = scan.nextInt();
            sb.append(Dy[N]).append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) {
        preprocess();
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

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
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