import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B16472 {
    static int N, cnt = 0;
    static String A;
    static int APH[];

    public static void main(String[] args) {
        input();
        pro();
    }

    static public void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        A = scan.nextLine();
        APH = new int[26];

    }

    static void add(char T) {
        if (APH[T - 'a'] == 0)
            cnt++;
        APH[T - 'a']++;
    }

    static void delete(char T) {
        APH[T - 'a']--;
        if (APH[T - 'a'] == 0)
            cnt--;
    }

    private static void pro() {
        int max = A.length();
        int ans = 0;

        for (int R = 0, L = 0; R < max; R++) {
            add(A.charAt(R));
            while (cnt > N) {
                delete(A.charAt(L++));
            }

            ans = Math.max(ans, R - L + 1);
        }
        System.out.println(ans);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

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

        public int nextInt() {
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
