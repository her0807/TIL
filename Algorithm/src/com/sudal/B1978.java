import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1978 {

    public static void main(String[] args) {
        input();
    }

    private static void input() {
        FastReader scan = new FastReader();
        int n, count = 0, check;
        n = scan.nextInt();

        while (n-- > 0) {
            check = scan.nextInt();
            if (check!=1 && isPromise(check))
                count++;
        }

        System.out.println(count);
    }

    private static boolean isPromise(int check) {
        for (int i = 2; i * i <= check; i++) {
            if (check % i == 0) return false;
        }
        return true;
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
