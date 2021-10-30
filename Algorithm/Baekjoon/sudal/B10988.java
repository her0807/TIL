import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10988 {
    public static void main(String[] args) {
        FastReader scan = new FastReader();
        String str = scan.next();
        int length = str.length();
        for (int i = 0; i < length / 2; i++) {
            if (!(str.charAt(i) == str.charAt(length - i - 1))) {
                System.out.println("0");
                return;
            }
        }
        System.out.println("1");
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
