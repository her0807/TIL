import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class B2637 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static class Info {
        int y, v;

        Info(int y, int v) {
            this.y = y;
            this.v = v;
        }
    }

    static int N, M;
    static int[] indeg;
    static int[][] cnt;
    static ArrayList<Info>[] adj;
    static boolean visit[];

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        adj = new ArrayList[N + 1];
        indeg = new int[N + 1];
        cnt = new int[N + 1][N + 1];
        visit = new boolean[N + 1];
        for (int i = 1; i <= N; i++)
            adj[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            int y = scan.nextInt(), x = scan.nextInt(), v = scan.nextInt();
            adj[x].add(new Info(y, v));
            indeg[y]++;
        }
    }

    static void pro() {
        Deque<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (indeg[i] == 0) {
                q.add(i);
                visit[i] = true;
            }
            cnt[i][i] = 1;
        }

        while (!q.isEmpty()) {
            int x = q.poll();
            for (Info i : adj[x]) {
                int y = i.y, v = i.v;
                indeg[y]--;
                // 제품 y에 제품 x 가 v 개 필요하므로 기본 부품 개수에 v 를 곱해서 누적시켜 준다.
                for (int j = 1; j <= N; j++) {
                    cnt[y][j] += cnt[x][j] * v;
                }
                if (indeg[y] == 0) q.add(y);
            }
        }
        for (int i = 1; i <= N; i++)
            if (visit[i] && cnt[N][i] != 0)
                System.out.println(i + " " + cnt[N][i]);
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

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
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