import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B11098 {

    public static void main(String[] args) {
        FastReader scan = new FastReader();
        StringBuffer sb = new StringBuffer();
        HashMap<Integer, String> list = new HashMap<>();
        int repeat = scan.nextInt();

        while (repeat-- > 0) {
            int count = scan.nextInt();
            int max = 0;
            while (count-- > 0) {
                int price = scan.nextInt();
                String name = scan.next();
                max = Math.max(price, max);
                list.put(price, name);
            }
            sb.append(list.get(max)).append("\n");
            list.clear();
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
