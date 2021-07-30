import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B5567 {
    static int N, M;
    static ArrayList<Integer>[] adj;
    static int cut = 0;
    static boolean[] visit;

    public static void main(String[] args) {
        input();
        pro();
    }


    private static void pro() {
        bfs(1);
        System.out.println(cut);


    }

    static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();

        que.add(start);
        visit[start] = true;
        while (!que.isEmpty()) {
            int x = que.poll();

            for (int y : adj[x]) {
                if (visit[y]) continue;
                if (x == 1) {
                    que.add(y);
                    cut++;
                    visit[y] = true;
                } else {
                    cut++;
                    visit[y] = true;

                }
            }
        }
    }

    private static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        adj = new ArrayList[N + 1];
        visit = new boolean[10000];
        for (int i = 1; i <= N; i++)
            adj[i] = new ArrayList<>();
        for (int i = 1; i <= M; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
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

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
