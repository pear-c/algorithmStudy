import java.util.HashMap;

public class Solution {
    static int solution(int N, int M, int[] A) {
        int answer = Integer.MAX_VALUE;
        HashMap<Integer, Integer> fishCount = new HashMap<>();
        int left = 0;
        int extraFish = 0;

        for(int i=0; i<N; i++) {
            // 낚시 못하면 초기화
            if(A[i] == -1) {
                fishCount.clear();
                left = i + 1;
                extraFish = 0;
                continue;
            }

            // 수산시장
            else if(A[i] == -2) {
                extraFish++;
            }

            else {
                // 현재 구역 물고기 종류 카운트 증가
                fishCount.put(A[i], fishCount.getOrDefault(A[i], 0) + 1);
            }

            // 모든 종류 물고기 포함될때까지 포인터 이동
            while(fishCount.size() + extraFish >= M) {
                answer = Math.min(answer, i - left + 1);

                if(A[left] == -2)
                    extraFish--;
                else {
                    // 왼쪽 물고기 포인터 제거
                    fishCount.put(A[left], fishCount.get(A[left]) - 1);
                    if(fishCount.get(A[left]) == 0) {
                        fishCount.remove(A[left]);
                    }
                }
                left++;
            }
        }
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    public static void main(String[] args) {
        int N = 8;
        int M = 3;
        int[] A = {1, -1, 3, 2, 3, -2, 3, 1};
        System.out.println(solution(N, M, A)); // 출력: 3
    }
}
