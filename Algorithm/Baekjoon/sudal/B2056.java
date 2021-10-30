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

public class B2056 {
    static int N;
    static ArrayList<Integer>[] adj;
    static int[] indeg, weight, ans;

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        adj = new ArrayList[N + 1];
        indeg = new int[N + 1];
        weight = new int[N + 1];
        ans = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            weight[i] = scan.nextInt();
            int x = scan.nextInt();
            while (x-- > 0) {
                int y = scan.nextInt();
                adj[y].add(i);
                indeg[i]++;
            }
        }
    }

    static void pro() {
        Deque<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indeg[i] == 0) {
                q.add(i);
                ans[i] = weight[i];
            }
        }

        while (!q.isEmpty()) {
            int x = q.poll();
            for (int y : adj[x]) {
                indeg[y]--;
                if (indeg[y] == 0)
                    q.add(y);
                ans[y] = Math.max(ans[y], ans[x] + weight[y]);
            }
        }
        int a = 0;
        for (int i = 1; i <= N; i++) {
            a = Math.max(a, ans[i]);
        }
        System.out.println(a);
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

    }
}