import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1292 {

    public static void main(String[] args) {
        input();
    }

    private static void input() {
        FastReader scan = new FastReader();
        int a, b, sum = 0, endPoint, count = 0;
        a = scan.nextInt();
        b = scan.nextInt();
        
        for (endPoint = 0; sum <= b; endPoint++) {
            sum += endPoint;
        }
        sum = 0;
        for (int i = 1; i < endPoint; i++) {
            for (int j = 0; j <i; j++) {
                count++;
                if (count < a)
                    continue;
                sum += i;
                if (count == b) {
                    System.out.println(sum );
                    break;
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
