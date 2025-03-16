package CodingTest.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// DFS/BFS Q.16 - 연구소
public class DFS_BFS_16 {
    static int N, M;
    static int[][] map;
    static List<int[]> emptySpaces = new ArrayList<>();
    static List<int[]> virusSpaces = new ArrayList<>();
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int maxSafeArea = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 연구실 정보 입력
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0) {
                    emptySpaces.add(new int[]{i, j});
                }
                if(map[i][j] == 2) {
                    virusSpaces.add(new int[]{i, j});
                }
            }
        }

        // 3개 벽 세우는 조합
        for(int i=0; i<emptySpaces.size(); i++) {
            for(int j=i+1; j< emptySpaces.size(); j++) {
                for(int k=j+1; k< emptySpaces.size(); k++) {
                    map[emptySpaces.get(i)[0]][emptySpaces.get(i)[1]] = 1;
                    map[emptySpaces.get(j)[0]][emptySpaces.get(j)[1]] = 1;
                    map[emptySpaces.get(k)[0]][emptySpaces.get(k)[1]] = 1;

                    int safeArea = getSafeArea();

                    maxSafeArea = Math.max(maxSafeArea, safeArea);

                    map[emptySpaces.get(i)[0]][emptySpaces.get(i)[1]] = 0;
                    map[emptySpaces.get(j)[0]][emptySpaces.get(j)[1]] = 0;
                    map[emptySpaces.get(k)[0]][emptySpaces.get(k)[1]] = 0;
                }
            }
        }

        System.out.println(maxSafeArea);
    }

    static int getSafeArea() {
        int[][] lab = new int[N][M];
        for(int i=0; i<N; i++) {
            lab[i] = map[i].clone();
        }

        Queue<int[]> queue = new LinkedList<>();
        for(int[] v : virusSpaces) {
            queue.add(v);
        }

        while(!queue.isEmpty()) {
            int[] v = queue.poll();
            for(int d=0; d<4; d++) {
                int nx = v[0] + dx[d];
                int ny = v[1] + dy[d];

                if(nx >= 0 && ny >= 0 && nx < N && ny < M && lab[nx][ny] == 0) {
                    lab[nx][ny] = 2;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        int safeCount = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(lab[i][j] == 0) {
                    safeCount++;
                }
            }
        }
        return safeCount;
    }
}
