import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11656 {
    public static void main(String[] args) {
        FastReader scan = new FastReader();
        String str = scan.next();
        String strArr[] = new String[str.length()];
        for(int i =0; i<str.length(); i++){
            strArr[i] = str.substring(i);
        }
        Arrays.sort(strArr);
        for (String a : strArr){
            System.out.println(a);
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
