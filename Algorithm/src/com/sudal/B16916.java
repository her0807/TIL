import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B16916 {
    public static void main(String[] args) {
        FastReader scan = new FastReader();
        String targetStr = scan.next();
        String partStr = scan.next();

        char[] pattern = partStr.toCharArray();
        char[] targets = targetStr.toCharArray();
        int[] table = new int[pattern.length];

        int k = 0;
        for (int i =   1; i < partStr.length(); i++) {
            while (k > 0 && pattern[i] != pattern[k]) {
                k = table[k - 1];
            }
            if (pattern[i] == pattern[k])
                table[i] = ++k;
        }
        k = 0;
        for (int i = 0; i < targetStr.length(); i++) {
            while (k > 0 && targets[i] != pattern[k]){
                k = table[k - 1];
            }
            if (targets[i] == pattern[k]) {
                if (k == partStr.length() - 1) {
                    System.out.println(1);
                    return;
                } else
                    k++;

            }
        }

        System.out.println(0);

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
