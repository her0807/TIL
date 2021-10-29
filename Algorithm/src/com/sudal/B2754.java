import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2754 {

    public static void main(String[] args) {
        FastReader scan = new FastReader();
        String score = scan.next();
        double sum = 0.0;
        switch (score.charAt(0)) {
            case 'A':
                sum += 4.0;
                break;
            case 'B':
                sum += 3.0;
                break;
            case 'C':
                sum += 2.0;
                break;
            case 'D':
                sum += 1.0;
                break;

            case 'F':
                System.out.println(sum);
                return;
        }
        switch (score.charAt(1)) {
            case '+':
                sum += 0.5;
                break;
            case '-':
                sum -= 0.3;
                break;
        }

        System.out.println(sum);
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
