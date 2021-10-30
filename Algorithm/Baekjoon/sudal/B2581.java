import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2581 {

    public static void main(String[] args) {
        input();
    }

    private static void input() {
        FastReader scan = new FastReader();
        int a, b, min = 0, sum = 0;
        a = scan.nextInt();
        b = scan.nextInt();

        while (b >= a) {
            if (a != 1 && isPromise(a)) {
                if (sum == 0) {
                    min = a;
                    sum += a;
                } else {
                    sum += a;
                }
            }
            a++;
        }
        if (sum == 0)
            System.out.println("-1");
        else
            System.out.println(sum + "\n" + min);
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
