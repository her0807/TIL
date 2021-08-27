import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2644 {

    static int N, M, X, Y;
    static boolean[][] graph;

    public static void main(String[] args) {
        input();
        pro();
    }

    private static void pro() {
        System.out.println(bfs(X, Y));
    }

    private static int bfs(int s, int e) {
        boolean[] visit = new boolean[N + 1];
        int ans = 0;
        Queue<Integer> Q = new LinkedList<>();
        visit[s] = true;
        Q.add(s);

        while (!Q.isEmpty()) {
            int size = Q.size();
            for (int j = 0; j < size; j++) {
                int temp = Q.poll();
                if (temp == e) {
                    return ans;
                }
                for (int i = 1; i <= N; i++) {
                    if (graph[temp][i] && !visit[i]) {
                        visit[i] = true;
                        Q.add(i);
                    }
                }
            }
            ans++;
        }
        return -1;
    }
    
    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();

        X = scan.nextInt();
        Y = scan.nextInt();

        graph = new boolean[N + 1][N + 1];

        M = scan.nextInt();
        for (int i = 0; i < M; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            graph[b][a] = graph[a][b] = true;
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
