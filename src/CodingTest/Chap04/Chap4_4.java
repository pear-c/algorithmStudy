package CodingTest.Chap04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Chap4_4 {
    // 동서남북 반시계 방향
    static int[][] directions = {
            {0, -1},    // 북쪽 보고 있을 때
            {1, 0},      // 서쪽 보고 있을 때
            {0, 1},     // 남쪽 보고 있을 때
            {-1, 0}    // 동쪽 보고 있을 때
    };
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N, M 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 현재 캐릭터 x, y 좌표, 방향 d 입력
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        // 맵 정보 입력
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        while(true) {
            int check = 0;  // 이동할 칸이 있는지 체크용(check = 4되면 이동할 칸 없음 의미)
            int next = 0;   // directions 배열 회전용
            int nx = 0;
            int ny = 0;
            for(int i=0; i<4; i++) {
                next = (d+i)%4;
                nx = x + directions[next][0];
                ny = y + directions[next][1];
                // N x M 배열 벗어나면 이동 x
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    count++;
                    continue;
                }

                // 동,서,남,북 중에 이동할 칸이 있는 경우
                if(map[nx][ny] == 0) {
                    map[x][y] = 2;  // 바다와의 구별을 위해 방문한 칸을 2로 설정
                    x = nx;
                    y = ny;
                    count++;
                    d = next;
                    break;
                }
                // 이동할 칸 없다면 체크
                else {
                    check++;
                }
            }

            // 네 방향 모두 갈 수 없는 경우
            if(check == 4) {
                nx = x - directions[next+1][0];
                ny = y - directions[next+1][1];
                // 뒤로 갈 수 있다면 이동
                if(map[nx][ny] == 2) {
                    map[x][y] = 2;
                    x = nx;
                    y = ny;
                    count++;
                }
                // 뒤가 바다로 막혀있는 경우
                else {
                    System.out.println(count);
                    break;
                }
            }
        }
    }
}
