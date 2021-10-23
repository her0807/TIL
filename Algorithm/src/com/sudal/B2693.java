import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2693 {

    public static void main(String[] args) {
        input();
    }

    private static void input() {
        FastReader scan = new FastReader();
        StringBuilder sb = new StringBuilder();
        int n = scan.nextInt();
        int[] arr = new int[10];

        while (n-- > 0) {
            for (int i = 0; i < 10; i++) {
                arr[i] = scan.nextInt();
            }
            Arrays.sort(arr);
            sb.append(arr[7]).append("\n");
        }
        System.out.println(sb);
    }


    static class FastReader {
        StringTokenizer st;
        BufferedReader br;

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
