import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11728 {
    static int N, M;
    static int[] A, B;

    public static void main(String[] args) {
        input();
        pro();
    }

    static void pro() {
        int i = 1, j = 1,  t =1;
        int[] T = new int[N + M + 1];
        StringBuilder sb = new StringBuilder();
        while(i<=N && j<=M){
            if(A[i]<B[j])
                T[t++] = A[i++];
            else
                T[t++] = B[j++];
        }
        while(i<=N) T[t++] = A[i++];
        while(j<=M) T[t++] = B[j++];
        for (int k = 1; k < T.length; k++)
            sb.append(T[k]).append(" ");
        System.out.println(sb);
    }

    private static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        A = new int[N + 1];
        B = new int[M + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
        }
        for (int i = 1; i <= M; i++) {
            B[i] = scan.nextInt();
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
