import java.util.ArrayList;
import java.util.Arrays;

public class Solution2 {

    static void solution(int N, int M, int H, int[][] S, int C, int L) {
        boolean[][] ladder = new boolean[H+1][N+1];
        int[] resultBefore = new int[N+1];
        int[] resultAfter = new int[N+1];
        ArrayList<Integer> res = new ArrayList<>();

        // 가로 줄 정보 설정
        for(int[] s : S) {
            int x = s[0];
            int y = s[1];
            ladder[y][x] = true;
        }

        // 사다리 탐색 (Before)
        for(int start=1; start<=N; start++) {
            int current = start;

            // 사다리 타기 시작 (내려오기)
            for(int y=H; y>=0; y--) {
                if(current >= 1 && ladder[y][current])
                    current++;
                else if(current <= N && ladder[y][current-1])
                    current--;
            }
            // 기존 사다리 탐색 결과
            resultBefore[start] = current;
        }

        // L제거
        for(int i=1; i<H; i++) {
            ladder[i][L] = false;
        }

        // 사다리 탐색 (After)
        for(int start=1; start<=N; start++) {
            int current = start;

            // 사다리 타기 시작 (내려오기)
            for(int y=H; y>=0; y--) {
                if(current >= 1 && ladder[y][current])
                    current++;
                else if(current <= N && ladder[y][current-1])
                    current--;
            }
            // 기존 사다리 탐색 결과
            resultAfter[start] = current;
        }

        // 결과 비교 후 바뀐 사다리 오름차순 출력
        for(int i=1; i<=N; i++) {
            if(resultBefore[i] != resultAfter[i]) {
                res.add(i);
            }
        }
        // 제거 후 다른 출발점 출력
        for(int i=0; i<res.size(); i++) {
            System.out.print(res.get(i) + " ");
        }
        System.out.println();

        for(int i=1; i<=N; i++) {
            if(resultAfter[i] == C)
                System.out.println("당첨: " + i);
        }
    }

    public static void main(String[] args) {
        int N = 5;
        int M = 3;
        int H = 4;
        int[][] S = {
                {1, 1},
                {3, 2},
                {4, 3}
        };

        int C = 4;
        int L = 3;
        solution(N, M, H, S, C, L);
    }
}
