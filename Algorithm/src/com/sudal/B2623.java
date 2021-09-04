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

public class B2623 {
    static int N, M;
    static ArrayList<Integer>[] adj;
    static int[] indeg;

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    private static void input() {
        N = scan.nextInt();
        M = scan.nextInt();

        adj = new ArrayList[N + 1];
        indeg = new int[N + 1];

        for (int i = 1; i <= N; i++)
            adj[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            int a = scan.nextInt(), x = scan.nextInt(), y;

            for (int j = 0; j < a - 1; j++) {
                y = scan.nextInt();
                adj[x].add(y);
                indeg[y]++;
                x = y;
            }
        }
    }

    private static void pro() {
        Deque<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (indeg[i] == 0)
                q.add(i);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int x = q.poll();
            ans.add(x);
            for (int i : adj[x]) {
                indeg[i]--;
                if (indeg[i] == 0)
                    q.add(i);
            }
        }
        if (N == ans.size())
            for (int x : ans) sb.append(x).append('\n');
        else sb.append(0);
        System.out.println(sb);
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