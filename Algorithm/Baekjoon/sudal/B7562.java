import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B7562 {
    static StringBuffer sb = new StringBuffer();
    static FastReader scan = new FastReader();
    static int[][] dir = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {-2, -1}, {-1, -2}, {2, -1}, {1, -2}};
    static int SIZE;
    static boolean[][] visit;
    static int[][] dist;


    public static void main(String[] args) {
        input();
        pro();
        System.out.println(sb);
    }

    private static void pro() {
        for (int i = 0; i < SIZE; i++) {
            int s = scan.nextInt();
            int x1 = scan.nextInt();
            int y1 = scan.nextInt();
            int x2 = scan.nextInt();
            int y2 = scan.nextInt();
            bfs(s, x1, y1, x2, y2);
            sb.append(dist[x2][y2] - 1).append("\n");
        }
    }

    static void bfs(int s, int x1, int y1, int x2, int y2) {
        Queue<Integer> q = new LinkedList<>();
        int ans = 0;
        visit = new boolean[s][s];
        visit[x1][y1] = true;
        dist = new int[s][s];

        dist[x1][y1] = 1;
        q.add(x1);
        q.add(y1);
        while (!q.isEmpty()) {
            int x = q.poll();
            int y = q.poll();

            for (int i = 0; i < 8; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];

                if (nx < 0 || ny < 0 || nx >= s || ny >= s) continue;
                if (visit[nx][ny]) continue;
                q.add(nx);
                q.add(ny);
                visit[nx][ny] = true;
                dist[nx][ny] = dist[x][y] + 1;
            }
        }
    }

    private static void input() {
        SIZE = scan.nextInt();
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
