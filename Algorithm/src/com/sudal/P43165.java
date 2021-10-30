public class P43165 {
    static boolean[] visit;
    static int ans = 0;

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 1};
        System.out.println(solution(arr, 3));
    }

    public static int solution(int[] numbers, int target) {
        visit = new boolean[numbers.length + 1];
        dfs(0, 0, numbers, target);
        return ans;
    }

    static void dfs(int dp, int sum, int[] numbers, int target) {
        if (dp == numbers.length) {
            if (sum == target)
                ans++;
            return;
        }
        for (int i = 0; i < 2; i++) {
            if (visit[dp]) {
                sum -= numbers[dp];
                visit[dp] = false;
            } else {
                sum += numbers[dp];
                visit[dp] = true;
            }

            dfs(dp + 1, sum, numbers, target);

            if (visit[dp]) {
                sum -= numbers[dp];
            } else {
                sum += numbers[dp];
            }
        }
    }
}
