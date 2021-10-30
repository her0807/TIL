import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1679 {
    static int N, M;
    static boolean visit[];
    static int dist[];

    public static void main(String[] args) {
        input();
        pro();
    }

    private static void pro() {
        bfs();
        System.out.println(dist[M]);
    }

    static void bfs() {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(N);
        visit[N] = true;
        dist[N] = 0;
        while (!Q.isEmpty()) {
            int x = Q.poll();

            if (x - 1 > 0 && !visit[x - 1]) {
                visit[x - 1] = true;
                dist[x - 1] = dist[x] + 1;
                Q.add(x - 1);
            }
            if (x + 1 <= 100000 && !visit[x + 1]) {
                visit[x + 1] = true;
                dist[x + 1] = dist[x] + 1;
                Q.add(x + 1);
            }
            if (x * 2 <= 100000 && !visit[x * 2]) {
                visit[x * 2] = true;
                dist[x * 2] = dist[x] + 1;
                Q.add(x * 2);
            }
        }
    }

    private static void input() {
        FastReader scan = new FastReader();
        visit = new boolean[100005];
        dist = new int[100005];
        N = scan.nextInt();
        M = scan.nextInt();
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
