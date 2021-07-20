

import java.io.*;
import java.util.*;

public class B2606 {
    static FastReader scan = new FastReader();

    static int V, M, C = 0;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;

    static void input() {
        V = scan.nextInt();
        M = scan.nextInt();

        adj = new ArrayList[V + 1];
        visit = new boolean[V + 1];

        for (int i = 1; i <= V; i++)
            adj[i] = new ArrayList<>();

        for (int i = 1; i <= M; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            adj[a].add(b);
            adj[b].add(a);
        }

    }

    static void dfs(int start) {
        visit[start] = true;
        C++;

        for (int a : adj[start]) {
            if (visit[a])
                continue;
            dfs(a);
        }
    }

    static void pro() {
        dfs(1);
        System.out.println(C - 1);

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