package CodingTest.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_11724 {

    static int N, M;
    static int[][] map;
    static boolean[] visited;

    static void dfs(int v) {
        visited[v] = true;
        for(int i = 1; i <= N; i++) {
            if(!visited[i] && map[v][i] == 1) {
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = 0;
        N = Integer.parseInt(st.nextToken()); // 정점의 개수
        M = Integer.parseInt(st.nextToken()); // 간선의 개수
        map = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = 1;
            map[y][x] = 1;
        }

        for(int i = 1; i <= N; i++) {
            if(!visited[i]) {
                dfs(i);
                count++;
            }
        }

        System.out.println(count);
    }
}
