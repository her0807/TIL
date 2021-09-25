import java.io.*;
import java.util.*;

public class B2011 {
    static FastReader scan = new FastReader();
    static String N;
    static long[] DP;

    static void preprocess() {
        DP = new long[N.length() + 1];
        DP[0] = 1;
        DP[1] = 1;


        if (N.charAt(0) == '0') {
            System.out.println(0);
            return;
        }

        for (int i = 1; i < N.length(); i++) {
            char pre = N.charAt(i - 1);
            if (N.charAt(i) >= '1' && N.charAt(i) <= '9') {
                DP[i + 1] += (DP[i]);
            }
            if (!(pre == '0' || pre > '2' || (pre == '2' && N.charAt(i) > '6'))) {
                DP[i + 1] += (DP[i - 1]);
            }
            DP[i + 1] %= 1000000;
        }
        System.out.println(DP[N.length()] % 1000000);
    }


    public static void main(String[] args) {
        N = scan.next();
        preprocess();
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
    }
}