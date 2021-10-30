import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B2504 {
    public static void main(String[] args) {
        FastReader scan = new FastReader();
        String in = scan.next();

        int mul = 1;
        int result = 0;
        Stack<Character> stack = new Stack<>();
        if (in.charAt(0) == ')' || in.charAt(0) == ']') {
            System.out.println(0);
            return;
        }

        for (int i = 0; i < in.length(); i++) {
            switch (in.charAt(i)) {
                case '(':
                    stack.push('(');
                    mul *= 2;
                    break;

                case '[':
                    stack.push('[');
                    mul *= 3;
                    break;

                case ')':
                    if (stack.isEmpty() || stack.peek() != '(') {
                        result = 0;
                        break;
                    }

                    if (in.charAt(i - 1) == '(')
                        result += mul;
                    stack.pop();
                    mul /= 2;
                    break;

                case ']':
                    if (stack.isEmpty() || stack.peek() != '[') {
                        result = 0;
                        break;
                    }

                    if (in.charAt(i - 1) == '[') result += mul;
                    stack.pop();
                    mul /= 3;
                    break;
            }
        }

        System.out.println(!stack.isEmpty() ? 0 : result);
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
