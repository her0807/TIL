import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B1240 {
    static int N, M, ANS;
    static ArrayList<Integer>[] adj;
    static int[][] weight;
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) {
        input();
        pro();
    }

    private static void pro() {
        while (M-- > 0) {
            int x = scan.nextInt();
            int y = scan.nextInt();

            dfs(x, -1, y, 0);

            sb.append(ANS).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int x, int p, int y, int dist) {
        if (x == y) {
            ANS = dist;
            return;
        }
        for (int i : adj[x]) {
            if (i == p) {
                continue;
            }
            dfs(i, x, y, dist + weight[x][i]);
        }
    }


    private static void input() {


        N = scan.nextInt();
        M = scan.nextInt();

        adj = new ArrayList[N + 1];
        weight = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++)
            adj[i] = new ArrayList<>();


        while (N-- > 1) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            int w = scan.nextInt();
            adj[x].add(y);
            adj[y].add(x);
            weight[y][x] = weight[x][y] = w;

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
