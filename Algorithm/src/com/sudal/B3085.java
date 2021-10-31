import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B3085 {
    static int n = 0, max = 0;
    static char[][] arr;

    public static void main(String[] args) {
        FastReader scan = new FastReader();
        n = scan.nextInt();
        arr = new char[n][n];

        for (int i = 0; i < n; i++) {
            String a = scan.next();
            for (int j = 0; j < n; j++) {
                arr[i][j] = a.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j + 1 < n && arr[i][j] != (arr[i][j + 1]))
                    rowChange(i, j, i, j + 1);
                if (i + 1 < n && arr[i][j] != (arr[i + 1][j]))
                    rowChange(i, j, i + 1, j);
            }
        }
        System.out.println(max);
    }


    public static void rowChange(int a, int b, int c, int d) {
        int count = 1;
        char str = arr[a][b];
        arr[a][b] = arr[c][d];
        arr[c][d] = str;

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n - 1; i++) {
                if (arr[j][i] == (arr[j][i + 1]))
                    count++;
                else {
                    count = 1;
                }
                max = Math.max(max, count);
            }
            count = 1;
        }

        count = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (arr[j][i] == (arr[j - 1][i]))
                    count++;
                else {
                    count = 1;
                }
                max = Math.max(max, count);
            }
            count = 1;
        }
        arr[c][d] = arr[a][b];
        arr[a][b] = str;
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
