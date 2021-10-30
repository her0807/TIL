import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B9470 {
    static int N, M, T;
    static ArrayList<Integer>[] adj;
    static int[] indeg, dp, order;
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) {
        int cycle = scan.nextInt();

        while (cycle-- > 0) {
            input();
            pro();
        }
        System.out.println(sb);
    }

    private static void input() {
        T = scan.nextInt();
        N = scan.nextInt();
        M = scan.nextInt();

        adj = new ArrayList[N + 1];
        indeg = new int[N + 1];
        dp = new int[N + 1];
        order = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            int x = scan.nextInt(), y = scan.nextInt();
            adj[x].add(y);
            indeg[y]++;
        }

    }

    private static void pro() {
        Deque<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indeg[i] == 0) {
                q.add(i);
                order[i] = dp[i] = 1;
            }
        }
        int ans = 0;
        while (!q.isEmpty()) {
            int x = q.poll();
            if (dp[x] >= 2)
                order[x]++;
            ans =  Math.max(ans,order[x]);
            for (int y : adj[x]) {
                indeg[y]--;
                if (indeg[y] == 0)
                    q.add(y);
                if (order[y] == order[x]) dp[y]++;
                else if (order[y] < order[x]) {
                    order[y] = order[x];
                    dp[y] = 1;
                }
            }
        }
        sb.append(T + " " + ans).append("\n");
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