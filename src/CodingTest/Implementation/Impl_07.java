package CodingTest.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 구현문제 Q.13 - 치킨 배달
// 1. 거리 : |r1 - r2| + |c1 - c2|
// 2. 치킨 거리 : 집과 가장 가까운 치킨집 사이의 거리
// 3. 도시의 치킨 거리 : 모든 집의 치킨 거리 합
// 4. (0: 빈칸 / 1: 집 / 2: 치킨집)
// 5. M : 가장 수익을 많이 낼 . 있는 치킨집의 개수
// 6. M개를 제외한 나머지는 폐업 -> 어떻게 하면 도시의 치킨 거리가 가장 작게 될지?
// 입력 : N, M, 도시 정보
// TODO : M개 보다 치킨집이 많으면, 치킨거리가 큰 순으로 제거
public class Impl_07 {
    static int N, M;
    static List<int[]> houses = new ArrayList<>();
    static List<int[]> chickens = new ArrayList<>();
    static List<List<int[]>> chickenCombinations = new ArrayList<>();
    static int minChickenDistance = Integer.MAX_VALUE;

    static void combination(int start, List<int[]> current) {
        if(current.size() == M) {
            chickenCombinations.add(new ArrayList<>(current));
            return;
        }

        for(int i=start; i<chickens.size(); i++) {
            current.add(chickens.get(i));
            combination(i+1, current);
            current.remove(current.size()-1);
        }
    }

    static int calcChickenDistance(List<int[]> chickens) {
        int totalDistance = 0;

        for(int[] house : houses) {
            int houseX = house[0];
            int houseY = house[1];
            int minDistance = Integer.MAX_VALUE;

            for(int[] chicken : chickens) {
                int chickenX = chicken[0];
                int chickenY = chicken[1];
                int distance = Math.abs(houseX - chickenX) + Math.abs(houseY - chickenY);
                minDistance = Math.min(minDistance, distance);
            }
            totalDistance += minDistance;
        }
        return totalDistance;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // N, M 입력
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        // 집, 치킨집 위치 정보 저장
        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                if(input[j].equals("1"))
                    houses.add(new int[]{i+1, j+1});
                else if(input[j].equals("2"))
                    chickens.add(new int[]{i+1, j+1});
            }
        }

        // 치킨집 구하기
        combination(0, new ArrayList<>());

        // 최소 치킨 거리 구하기
        for(List<int[]> selectedChickens : chickenCombinations) {
            minChickenDistance = Math.min(minChickenDistance, calcChickenDistance(selectedChickens));
        }
        System.out.println(minChickenDistance);
    }
}
