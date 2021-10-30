import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1120 {
    public static void main(String[] args) {
        FastReader scan = new FastReader();
        String a = scan.next();
        String b = scan.next();
        int ans = Integer.MAX_VALUE;
        int count = 0;
        if (a.length() - b.length() < 0) {
            String temp = b;
            b = a;
            a = temp;
        }

        for (int i = 0; i <= a.length() - b.length(); i++) {
            count = 0;
            for (int j = 0; j < b.length(); j++) {
                if (a.charAt(i + j) != b.charAt(j)) {
                    count++;
                }
            }
            ans = Math.min(ans, count);
        }
        System.out.println(ans);
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
    }
}
