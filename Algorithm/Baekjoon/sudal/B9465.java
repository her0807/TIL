import java.util.Scanner;

public class B9465 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int[][] arr = new int[2][n + 1];
            int[][] dp = new int[2][n + 1];
            for (int j = 0; j < 2; j++) {
                for (int k = 1; k <= n; k++) {
                    arr[j][k] = sc.nextInt();
                }
            }
            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];
            for (int a = 2; a <= n; a++) {
                dp[0][a] = Math.max(dp[1][a - 1], dp[1][a - 2]) + arr[0][a];
                dp[1][a] = Math.max(dp[0][a - 1], dp[0][a - 2]) + arr[1][a];
            }
            System.out.println(Math.max(dp[0][n], dp[1][n]));
        }
    }
}