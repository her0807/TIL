import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2309 {
    static int[] arr = new int[10];
    static int sum = 0;
    
    public static void main(String[] args) {
        input();
        pro();
    }

    private static void input() {
        FastReader scan = new FastReader();
        for (int i = 1; i < 10; i++) {
            arr[i] = scan.nextInt();
            sum += arr[i];
        }
        Arrays.sort(arr, 1, 10);
    }

    private static void pro() {
        int n = 9;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (sum - arr[i] - arr[j] == 100) {
                    for (int k = 1; k <= n; k++) {
                        if (i == k || j == k) {
                            continue;
                        }
                        System.out.println(arr[k]);
                    }
                    System.exit(0);
                }
            }
        }
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

