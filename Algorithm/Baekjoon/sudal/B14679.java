import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B14679 {

    static int N, M, K;
    static ArrayList<Integer>[] adj;
    static int[] indeg, pre, cunt;
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    private static void pro() {
        boolean ans = false;

        while (K-- > 0) {
            int x = scan.nextInt();
            int y = scan.nextInt();

            if (x == 1) {
                if (indeg[y] > pre[y])
                    ans = true;

                cunt[y]++;

                if (cunt[y] == 1) {
                    for (int a : adj[y])
                        pre[a]++;
                }
            } else {
                if (cunt[y] == 0)
                    ans = true;
                cunt[y]--;

                if (cunt[y] == 0) {
                    for (int a : adj[y])
                        pre[a]--;
                }
            }
        }
        if (ans) {
            System.out.println("Lier!");
        } else {
            System.out.println("King-God-Emperor");
        }
    }

    private static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        K = scan.nextInt();

        adj = new ArrayList[N + 1];

        indeg = new int[N + 1];
        pre = new int[N + 1];
        cunt = new int[N + 1];

        for (int i = 1; i <= N; i++)
            adj[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();

            adj[x].add(y);
            indeg[y]++;
        }
    }

    public static void main(String[] args) {
        input();
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