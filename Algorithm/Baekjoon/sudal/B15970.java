import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class B15970 {

    static int N;
    static ArrayList<Integer>[] color;
    static FastReader scan = new FastReader();

    static void input() {
        N = scan.nextInt();
        color = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            color[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            int x = scan.nextInt();
            int c = scan.nextInt();
            color[c].add(x);
        }
    }

    static void pro() {
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            Collections.sort(color[i]);

            for (int j = 0; j < color[i].size(); j++) {
                int lift = toLeft(i,j);
                int right = toRight(i,j);
                ans += Math.min(lift,right);
            }
        }

        System.out.println(ans);

}

    static int toLeft(int idx, int num) {
        if (num == 0)
            return Integer.MAX_VALUE;
        return color[idx].get(num) - color[idx].get(num - 1);
    }

    static int toRight(int idx, int num) {
        if (num + 1 == color[idx].size())
            return Integer.MAX_VALUE;
        return color[idx].get(num + 1) - color[idx].get(num);
    }

    public static void main(String[] args) {
        input();
        pro();
    }


static class FastReader {
    StringTokenizer st;
    BufferedReader br;


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
