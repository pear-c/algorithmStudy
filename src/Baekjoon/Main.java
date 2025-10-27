package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static char[][] graph;
    static int[][] dist;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static int bfs() {

        Queue<int[]> queue = new LinkedList<>();
        dist[0][0] = 1;
        queue.offer(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];

            if(x == N-1 && y == N-1) {
                return dist[x][y];
            }

            for(int d=0; d<4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if(nx >= 0 && ny >= 0 && nx < N && ny < M && graph[nx][ny] == '1' && dist[nx][ny] == 0) {
                    dist[nx][ny] = dist[x][y] + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new char[N][M];
        dist = new int[N][M];

        for(int i=0; i<N; i++) {
            String line = br.readLine();
            for(int j=0; j<M; j++) {
                graph[i][j] = line.charAt(j);
            }
        }

        System.out.println(bfs());
    }
}
