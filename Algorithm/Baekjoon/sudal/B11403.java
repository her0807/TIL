dist[i][j]import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B11403 {

    static int N;
    static int[][] A;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) {
        input();
        pro();

    }


    static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            visit[i] = false;
        }
        que.add(start);

        while (!que.isEmpty()) {
            int x = que.poll();

            for (int y = 1; y <= N; y++) {
                if (A[x][y] == 0)
                    continue;
                if (visit[y])
                    continue;

                que.add(y);
                visit[y] = true;
            }
        }
        for (int i = 1; i <= N; i++) {
            sb.append(visit[i] ? 1 : 0).append(' ');
        }
        sb.append('\n');
    }

    private static void pro() {
        visit = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            bfs(i);
        }
        System.out.println(sb);

    }

    private static void input() {
        FastReader scan = new FastReader();

        N = scan.nextInt();
        A = new int[N + 1][N + 1];
        for (int i = 1;i <= N; i++)
            for (int j = 1; j <= N; j++)
                A[i][j] = scan.nextInt();
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
