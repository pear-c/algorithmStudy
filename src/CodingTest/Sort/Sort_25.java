package CodingTest.Sort;

import java.util.*;

// 정렬 Q.25 : 프로그래머스 42889 - 실패율
// 실패율 : 스테이지 도달 했으나 아직 클리어 X 플레이어 / 스테이지 도달한 플레이어 수
// 전체 스테이지 개수 : N
// 사용자가 현재 멈춰있는 스테이지 번호 배열 : stages
// 실패율이 높은 스테이지부터 내림차순 정렬
public class Sort_25 {
    static class Stage {
        int index;
        double failRate;

        public Stage(int index, double failRate) {
            this.index = index;
            this.failRate = failRate;
        }
    }
    static int[] solution(int N, int[] stages) {
        int[] clearArr = new int[N+2];
        for(int stage : stages) {
            clearArr[stage]++;
        }

        int player = stages.length;
        List<Stage> failRates = new ArrayList<>();

        for(int i=1; i<=N; i++) {
            if(player == 0) {
                failRates.add(new Stage(i, 0));
            } else {
                double failRate = (double) clearArr[i] / player;
                failRates.add(new Stage(i, failRate));
            }
            player -= clearArr[i];
        }

        Collections.sort(failRates, new Comparator<Stage>() {
            @Override
            public int compare(Stage o1, Stage o2) {
                if(o1.failRate == o2.failRate) {
                    return o1.index - o2.index;
                } else {
                    return Double.compare(o2.failRate, o1.failRate);
                }
            }
        });

        int[] answer = new int[N];
        for(int i=0; i<N; i++) {
            answer[i] = failRates.get(i).index;
        }
        return answer;
    }

    public static void main(String[] args) {
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};

        int[] result = solution(N, stages);
        for(int i : result) {
            System.out.print(i + " ");
        }
    }
}
