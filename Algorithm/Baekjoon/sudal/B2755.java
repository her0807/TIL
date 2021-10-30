import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2755 {
    static double sum = 0.0;
    static int grade = 0;

    public static void main(String[] args) {
        FastReader scan = new FastReader();
        int repeat = scan.nextInt();
        while (repeat-- > 0) {
            String name = scan.next();
            int g = scan.nextInt();
            String score = scan.next();
            sum += (carculate(score) * g);
            grade += g;
        }
        System.out.printf("%.2f", sum / grade);
    }

    public static double carculate(String score) {
        double one = 0.0;

        switch (score.charAt(0)) {
            case 'A':
                one += 4.0;
                break;
            case 'B':
                one += 3.0;
                break;
            case 'C':
                one += 2.0;
                break;
            case 'D':
                one += 1.0;
                break;
            case 'F':
                return 0.0;

        }
        switch (score.charAt(1)) {
            case '+':
                one += 0.3;
                break;
            case '-':
                one -= 0.3;
                break;
        }
        return one;
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
