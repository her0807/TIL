import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1015 {

    static class Adj implements Comparable<Adj> {
        int idx, num;

        public Adj(int num, int idx){
            this.num = num;
            this.idx = idx;
        }

        @Override
        public int compareTo(Adj other) {
            if (num != other.num)
                return num - other.num;
            return idx - other.idx;
        }
    }

    static int N;
    static int[] P;
    static Adj[] B;
    static StringBuilder sb  = new StringBuilder();


    static void input(){
        FastReader scan = new FastReader();
        N = scan.nextInt();
        B = new Adj[N];
        P = new int[N];

        for(int i =0; i<N; i++){
            B[i] = new Adj(scan.nextInt(),i);
        }
    }

    static void pro(){
        Arrays.sort(B);

        for(int i =0; i<N; i++){
            P[B[i].idx] = i;
        }

        for(int i : P){
            sb.append(i+" ");
        }

        System.out.println(sb);


    }
    static public void main(String[] args) {
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
