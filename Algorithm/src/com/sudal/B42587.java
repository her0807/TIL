import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class B42587 {

    public static void main(String[] args) {
        int[] priorities = new int[]{1, 1, 9, 1, 1, 1};
        System.out.println(solution(priorities, 0));

    }

    public static int solution(int[] priorities, int location) {
        int[] max = new int[10];
        int answer = 0;

        Queue<Integer> que = new LinkedList<>();
        for (int a : priorities) {
            max[a]++;
            que.add(a);
            que.add(answer++);
        }

        answer = 0;
        int pre = find(max, 9);
        while (!que.isEmpty()) {

            if (que.peek() != pre) {
                que.add(que.poll());
                que.add(que.poll());
            } else {
                answer++;
                que.poll();
                if (que.poll() == location) {
                    break;
                } else {
                    max[pre]--;
                }
            }
            if (max[pre] == 0)
                pre = find(max, pre);
        }
        return answer;
    }

    public static int find(int[] arr, int pre) {
        int max = 0;
        for (int i = pre; i > 0; i--) {
            if (arr[i] > 0) {
                max = i;
                break;
            }
        }
        return max;
    }

}
