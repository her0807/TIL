import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class B9489 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n, K;
    static int[] a, par;

    static void input() throws IOException {
        n = scan.nextInt();
        K = scan.nextInt();
        a = new int[n + 1];
        par = new int[n + 1];
        for (int i = 1; i <= n; i++) a[i] = scan.nextInt();
    }

    static void pro() {

        par[0] = -1;
        par[1] = 0;

        int last = 1;
        for (int i = 2; i <= n; i++, last++) {
            for (; i <= n; i++) {
                par[i] = last;
                if (i < n && a[i] + 1 != a[i + 1]) {
                    break;
                }
            }
        }

        int kIdx = 0;  // 수가 K인 정점의 인덱스
        for (int i = 1; i <= n; i++)
            if (a[i] == K) kIdx = i;
        int ans = 0;
        for (int i = 1; i <= n; i++)
            if (par[par[i]] == par[par[kIdx]] && par[i] != par[kIdx])
                ans++;

        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        while (true) {
            input();
            if (n == 0 && K == 0) break;
            pro();
        }
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
