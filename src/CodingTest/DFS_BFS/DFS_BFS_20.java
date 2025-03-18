package CodingTest.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// DFS/BFS Q.20 - 감시 피하기
public class DFS_BFS_20 {
    static int N;
    static char[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static List<int[]> teachers = new ArrayList<>();
    static List<int[]> emptySpaces = new ArrayList<>();
    static boolean result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 초기 정보 입력
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for(int j=0; j<N; j++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                char c = st.nextToken().charAt(0);
                map[j][i] = c;
                if(c == 'T') {
                    teachers.add(new int[]{j, i});
                }
                if(c == 'X') {
                    emptySpaces.add(new int[]{j, i});
                }
            }
        }


        // 장애물 설치
        for(int i=0; i<emptySpaces.size(); i++) {
            for(int j=i+1; j<emptySpaces.size(); j++) {
                for(int k=j+1; k<emptySpaces.size(); k++) {
                    map[emptySpaces.get(i)[0]][emptySpaces.get(i)[1]] = 'O';
                    map[emptySpaces.get(j)[0]][emptySpaces.get(j)[1]] = 'O';
                    map[emptySpaces.get(k)[0]][emptySpaces.get(k)[1]] = 'O';

                    result = isAvoidTeacher();
                    if (result) {
                        System.out.println("YES");
                        return;
                    }

                    map[emptySpaces.get(i)[0]][emptySpaces.get(i)[1]] = 'X';
                    map[emptySpaces.get(j)[0]][emptySpaces.get(j)[1]] = 'X';
                    map[emptySpaces.get(k)[0]][emptySpaces.get(k)[1]] = 'X';
                }
            }
        }
        System.out.println("NO");
    }

    static boolean isAvoidTeacher() {
        char[][] temp = new char[N][N];
        for(int i=0; i<N; i++) {
            temp[i] = map[i].clone();
        }

        for(int[] teacher : teachers) {
            int y = teacher[0];
            int x = teacher[1];

            // 네 방향 감시
            for(int d=0; d<4; d++) {
                int ny = y;
                int nx = x;

                while(true) {
                    ny += dy[d];
                    nx += dx[d];

                    if(ny < 0 || nx < 0 || ny >= N || nx >= N || temp[ny][nx] == 'O') {
                        break;
                    }
                    if(temp[ny][nx] == 'S') {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
