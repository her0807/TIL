import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1032 {
    static int R;
    static String[] str;

    public static void main(String[] args) {
        input();
        pro();
    }


    static void input() {
        FastReader scan = new FastReader();
        R = scan.nextInt();
        str = new String[R];
        for (int i = 0; i < R; i++) {
            str[i] = scan.next();
        }
    }

    static void pro() {
        StringBuffer sb = new StringBuffer(str[0]);
        for (int i = 1; i < R; i++) {
            for (int j = 0; j < str[i].length(); j++) {
                if (sb.charAt(j) != '?' && sb.charAt(j) != str[i].charAt(j)) {
                    sb.setCharAt(j, '?');
                }
            }
        }
        System.out.println(sb);
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