import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B9093 {
    public static void main(String[] args) {
        FastReader scan = new FastReader();
        int repeat = scan.nextInt();
        StringBuffer sb = new StringBuffer();
        while (repeat-- > 0) {
            String str = scan.nextLine();
            String[] arr = str.split(" ");
            for (String s : arr) {
                for (int i = s.length() - 1; i >= 0; i--) {
                    sb.append(s.charAt(i));
                }
                sb.append(" ");
            }
            sb.append("\n");
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

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
