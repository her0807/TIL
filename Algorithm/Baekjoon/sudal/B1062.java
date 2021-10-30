ㄹㅎgdimport java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1062 {
    static int K, N, MAX = 0;
    static String[] word;
    static boolean[] check;

    public static void main(String[] args) {
        FastReader scan = new FastReader();

        K = scan.nextInt();
        N = scan.nextInt();

        if (N < 5) { //a c i n t의 개수가 5개이므로
            System.out.println("0");
            return;
        } else if (N == 26) { //모든 알파벳을 다 읽을 수 있다.
            System.out.println(K);
            return;
        }

        word = new String[K];
        check = new boolean[26];

        for (int i = 0; i < K; i++) {
            String inputWord = scan.next();
            inputWord = inputWord.replace("anta", "");
            inputWord = inputWord.replace("tica", "");
            word[i] = inputWord;
        }
        check['a' - 'a'] = true;
        check['c' - 'a'] = true;
        check['i' - 'a'] = true;
        check['t' - 'a'] = true;
        check['n' - 'a'] = true;
        backtracking(0, 0);
        System.out.println(MAX);
    }

    public static void backtracking(int alpha, int len) {
        if (len == N - 5) {
            int max = 0;
            for (int i = 0; i < K; i++) {
                boolean isRead = true;
                for (int j = 0; j < word[i].length(); j++) {
                    int index = word[i].charAt(j) - 'a';
                    if (!check[index]) {
                        isRead = false;
                        break;
                    }
                }
                if (isRead)
                    max++;
            }
            MAX = Math.max(MAX, max);
            return;
        }
        for (int i = alpha; i < 26; i++) {
            if (check[i] == false) {
                check[i] = true;
                backtracking(i, len + 1);
                check[i] = false;
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
