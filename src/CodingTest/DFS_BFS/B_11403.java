package CodingTest.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_11403 {

    static int N;
    static int[][] map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int k = 1; k <= N; k++) {
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    if(map[i][k] == 1 && map[k][j] == 1) {
                        map[i][j] = 1;
                    }
                }
            }
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                sb.append(map[i][j] + " ");
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}
