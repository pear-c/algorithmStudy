package CodingTest.DFS_BFS;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// DFS/BFS Q.21 - 인구 이동
public class DFS_BFS_21 {
    static int N, L, R;
    static int[][] map;
    static boolean[][] visited;
    static List<int[]> crews = new ArrayList<>(); // 연합
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int count = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        L = sc.nextInt();
        R = sc.nextInt();
        map = new int[N][N];
        visited = new boolean[N][N];
        for(int j=0; j<N; j++) {
            for(int i=0; i<N; i++) {
                map[j][i] = sc.nextInt();
            }
        }

        int[][] prev;
        do {
            prev = new int[N][N];
            for(int j=0; j<N; j++) {
                prev[j] = map[j].clone();
            }

            for(int j=0; j<N; j++) {
                for(int i=0; i<N; i++) {
                    makeCrew(j, i);
                }
            }

            if(!crews.isEmpty()) {
                movePerson();
                count++;
            }
        } while(!isEqual(prev, map));

        System.out.println(count);
    }

    static void movePerson() {
        int sum = 0;
        for(int i=0; i<crews.size(); i++) {
            sum += map[crews.get(i)[0]][crews.get(i)[1]];
        }
        int avg = sum / crews.size();

        for(int[] pos : crews) {
            map[pos[1]][pos[0]] = avg;
        }
        crews.clear();
    }

    static boolean isEqual(int[][] prev, int[][] map) {
        for(int j=0; j<N; j++) {
            for(int i=0; i<N; i++) {
                if(map[j][i] != prev[j][i])
                    return false;
            }
        }
        return true;
    }


    static void makeCrew(int y, int x) {
        for(int i=0; i<4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny >= 0 && nx >= 0 && ny < N && nx < N) {
                if(!visited[ny][nx]) {
                    int sub = Math.abs(map[y][x] - map[ny][nx]);


                    if(sub >= L && sub <= R) {
                        if(!visited[y][x]) {
                            crews.add(new int[]{y, x});
                            visited[y][x] = true;
                        }
                        crews.add(new int[]{ny, nx});
                        visited[ny][nx] = true;
                    }
                }
            }
        }
    }
}
