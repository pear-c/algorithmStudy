package CodingTest.Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Impl_05 {
    static class Pos {
        int x;
        int y;
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static class Vector {
        int time;
        char direction;

        public Vector(int time, char direction) {
            this.time = time;
            this.direction = direction;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1. 보드 초기화, 사과 위치 설정
        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];
        int K = Integer.parseInt(br.readLine());
        for(int apple = 0; apple < K; apple++){
            String[] input = br.readLine().split(" ");
            int row = Integer.parseInt(input[0]);
            int col = Integer.parseInt(input[1]);
            board[row-1][col-1] = -1;
        }

        // 2. 방향 변환 정보 저장. (클래스)
        Queue<Vector> directions = new LinkedList<>();
        int L = Integer.parseInt(br.readLine());
        for(int dir = 0; dir < L; dir++){
            String[] input = br.readLine().split(" ");
            Vector vector = new Vector(Integer.parseInt(input[0]), input[1].charAt(0));
            directions.add(vector);
        }

        // 3. 방향 벡터 설정 (상,하,좌,우)
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        // 게임시작 - 초기 위치 : (0, 0) / 초기 방향 상태 : 오른쪽 (x + 1, y + 0)
        int x = 0, y = 0;
        board[x][y] = 1;
        int length = 1;
        int time = 0;
        int dxIndex = 0;
        int dyIndex = 0;
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(x, y));
        Vector checkV = directions.poll();

        while(true) {
            time++;
            int nx = x + dx[dxIndex];
            int ny = y + dy[dyIndex];

            if(nx >= N || ny >= N || nx < 0 || ny < 0 || board[ny][nx] == 1) {
                break;
            }

            if(board[ny][nx] == -1){
                length++;
            }

            board[ny][nx] = 1;
            x = nx;
            y = ny;
            queue.add(new Pos(nx, ny));

            if(queue.size() > length) {
                Pos pos = queue.poll();
                board[pos.y][pos.x] = 0;
            }
            // 해당 시간 됐을 때 방향 전환
            if(time == checkV.time) {
                if(checkV.direction == 'D') {
                    dxIndex = (dxIndex+1)%4;
                    dyIndex = (dyIndex+1)%4;
                }
                else if(checkV.direction == 'L') {
                    if(dxIndex == 0)
                        dxIndex = 3;
                    else
                        dxIndex--;

                    if(dyIndex == 0)
                        dyIndex = 3;
                    else
                        dyIndex--;
                }

                if(!directions.isEmpty())
                    checkV = directions.poll();
            }
        }

        System.out.println(time);
    }
}
