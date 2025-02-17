package CodingTest.Implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 구현 문제 - Q.12. 기둥과 보 설치
public class Impl_06 {
    static boolean[][] vertical;    // 기둥 설계도
    static boolean[][] horizontal;  // 보 설계도

    static int[][] solution(int n, int[][] build_frame) {
        // 구조물 설치 및 삭제
        vertical = new boolean[n+1][n+1];
        horizontal = new boolean[n+1][n+1];

        for(int[] arr : build_frame){
            int x = arr[0];
            int y = arr[1];
            int structure = arr[2]; // 기둥 : 0, 보 : 1
            int state = arr[3];     // 설치 : 1, 삭제 : 0
            // 설치
            if(state == 1) {
                // 기둥 설치 (기둥 : 0)
                if(structure == 0) {
                    // 1) 바닥 위에 있거나,
                    // 2) 아래에 기둥이 있거나,
                    // 3) 보의 한쪽 끝이 연결 돼 있을 때
                    if(y == 0 || vertical[y-1][x] || horizontal[y][x] || (x > 0 && horizontal[y][x-1])) {
                        vertical[y][x] = true;
                    }
                }
                // 보 설치 (보 : 1)
                else if(structure == 1) {
                    // 1) 왼쪽 끝이 기둥 위에 있거나,
                    // 2) 오른쪽 끝이 기둥 위에 있거나,
                    // 3) 양쪽 보가 연결 돼있을 때
                    if(vertical[y-1][x] || vertical[y-1][x+1] || (x > 0 && horizontal[y][x-1] && horizontal[y][x+1])) {
                        horizontal[y][x] = true;
                    }
                }
            }
            // 삭제
            else if(state == 0) {
                // 기둥 삭제
                if(structure == 0) {
                    vertical[y][x] = false;
                    // 모든 기둥과 보가 정상적으로 유지되는지 확인
                    for (int i = 0; i <= n; i++) {
                        for (int j = 0; j <= n; j++) {
                            if (vertical[j][i] && !(j == 0 || vertical[j-1][i] || horizontal[j][i] || (i > 0 && horizontal[j][i-1]))) {
                                vertical[y][x] = true; // 복구
                                break;
                            }
                            if (horizontal[j][i] && !(vertical[j-1][i] || vertical[j-1][i+1] || (i > 0 && horizontal[j][i-1] && horizontal[j][i+1]))) {
                                vertical[y][x] = true; // 복구
                                break;
                            }
                        }
                    }
                }
                // 보 삭제
                else if(structure == 1) {
                    horizontal[y][x] = false;
                    // 모든 기둥과 보가 정상적으로 유지되는지 확인
                    for (int i = 0; i <= n; i++) {
                        for (int j = 0; j <= n; j++) {
                            if (vertical[j][i] && !(j == 0 || vertical[j-1][i] || horizontal[j][i] || (i > 0 && horizontal[j][i-1]))) {
                                horizontal[y][x] = true; // 복구
                                break;
                            }
                            if (horizontal[j][i] && !(vertical[j-1][i] || vertical[j-1][i+1] || (i > 0 && horizontal[j][i-1] && horizontal[j][i+1]))) {
                                horizontal[y][x] = true; // 복구
                                break;
                            }
                        }
                    }
                }
            }
        }

        // 최종 구조물 상태 리턴
        List<int[]> result = new ArrayList<>();
        for(int x=0; x<=n; x++) {
            for(int y=0; y<=n; y++) {
                if(vertical[y][x])
                    result.add(new int[] {x, y, 0});
                if(horizontal[y][x])
                    result.add(new int[] {x, y, 1});
            }
        }
        return result.toArray(new int[0][]);
    }
    public static void main(String[] args) {
        int n = 5;
        int[][] build_frame = {
                {0, 0, 0, 1},
                {2, 0, 0, 1},
                {4, 0, 0, 1},
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {2, 1, 1, 1},
                {3, 1, 1, 1},
                {2, 0, 0, 0},
                {1, 1, 1, 0},
                {2, 2, 0, 1}
        };
        int[][] solution = solution(n, build_frame);
        for(int i=0; i<solution.length; i++) {
            for(int j=0; j<solution[i].length; j++) {
                System.out.print(solution[i][j] + " ");
            }
            System.out.println();
        }
    }
}
