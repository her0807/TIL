public class B42842 {

    public static void main(String[] args) {

    }

    // 가로 세로 구하는 내용
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for (int i = 1; i < 5000; i++) {
            for (int j = 1; j <= i; j++) {
                if (2 * i + 2 * j - 4 == brown) {
                    if (i * j - brown == yellow) {
                        answer[0] = i;
                        answer[1] = j;
                    }
                }
            }
        }
        return answer;
    }
}
