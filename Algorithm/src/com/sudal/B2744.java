import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.StringTokenizer;

public class B2744 {
    public static void main(String[] args) {
        FastReader scan = new FastReader();
        String str = scan.next();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            String a = str.substring(i, i+1);
            if (str.charAt(i) - 'a' >= 0)
                sb.append(a.toUpperCase(Locale.ROOT));
            else
                sb.append(a.toLowerCase(Locale.ROOT));
        }
        System.out.println(sb);
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
