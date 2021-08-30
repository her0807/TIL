import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1389 {
    static boolean[][] g;
    static int N, M;


    public static void main(String[] args) {
        input();
        pro();
    }

    private static void pro() {
        int min = bfs(1);
        int index = 1;

        for (int i = 2; i <= N; i++) {
            int x = bfs(i);
            if (min > x) {
                min = x;
                index = i;
            }
        }
        System.out.println(index);
    }

    private static int bfs(int x) {
        boolean[] visit = new boolean[N + 1];
        Queue<Integer> q = new LinkedList<>();
        int ans = 0;
        visit[x] = true;
        q.add(x);
        int cut = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int j = 0; j < size; j++) {
                int t = q.poll();
                for (int i = 1; i <= N; i++) {
                    if (g[t][i] && !visit[i]) {
                        visit[i] = true;
                        q.add(i);
                        ans += cut;
                    }
                }
            }
            cut++;
        }
        return ans;
    }

    private static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();

        g = new boolean[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            g[y][x] = g[x][y] = true;
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
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
