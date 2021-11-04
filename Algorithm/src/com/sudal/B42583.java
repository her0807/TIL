import java.util.LinkedList;
import java.util.Queue;

public class B42583 {
    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = new int[]{7, 4, 5, 6};
        System.out.println(solution(bridge_length, weight, truck_weights));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Queue<Integer> bridgeQue = new LinkedList<>();
        Queue<Integer> readyTruckQue = new LinkedList<>();

        //초기 다리 상태 세팅
        for (int i = 0; i < bridge_length; i++) {
            bridgeQue.add(0);
        }

        //대기 트럭 세팅
        for (int i : truck_weights) {
            readyTruckQue.add(i);
        }

        int time = 0;
        int totalWeight = 0;
        while (!bridgeQue.isEmpty()) {
            //while 한번 도는게 1초라고 생각
            //시작하자마자 다리 맨 마지막부분에서 트럭을 빼버림
            totalWeight -= bridgeQue.poll();

            //대기 트럭열에 있던 마지막 트럭이 다리에 올라가면, 다리 길이 만큼의 시간 후에
            //마지막 트럭이 다리를 건너기때문에 다리 길이(*1초) 만큼 시간이 소요되면 모든 트럭이 건너게됨
            if (readyTruckQue.isEmpty()) {
                time += bridge_length;
                break;
            } else {
                //다리의 하중량을 버틸 수 있으면 트럭 투입
                if ((totalWeight + readyTruckQue.peek()) <= weight) {
                    bridgeQue.add(readyTruckQue.peek());
                    totalWeight += readyTruckQue.poll();
                }
                //다리의 하중량때문에 트럭 못들어가면 0으로 넣어줌
                else {
                    bridgeQue.add(0);
                }
            }
            time++;
        }

        answer = time;

        return answer;
    }

}
