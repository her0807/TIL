import java.io.*;
import java.util.*;

public class B20291 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static class MyComparator implements Comparator<String> {
        @Override
        public int compare(String lhs, String rhs) {
            return lhs.compareTo(rhs);
        }
    }

    static int N;
    static String[] a;

    static void input() {
        N = scan.nextInt();
        a = new String[N];
        for (int i = 0; i < N; i++) {
            String b = scan.next();
            a[i] = b.substring(b.indexOf(".") + 1);
        }
    }

    static void pro() {
        // TODO
        // 정렬 조건에 맞게 단어를 정렬하기
        Arrays.sort(a, new MyComparator());
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (i == 0 || a[i].compareTo(a[i - 1]) == 0) {
                count++;
            } else {
                sb.append(a[i - 1] + " " + count).append('\n');
                count = 1;
            }
        }
        sb.append(a[N-1] + " " + count).append('\n');
        System.out.println(sb.toString());
        // 출력하기
    }

    public static void main(String[] args) {
        input();
        pro();
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

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
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
    }
}