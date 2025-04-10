package CodingTest.ShortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class ShortPath_38 {
    static int[] dx = {1, 0}; // 오른쪽
    static int[] dy = {0, 1}; // 아래쪽
    static int tc, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        tc = Integer.parseInt(br.readLine());
        while(tc-- > 0) {
            N = Integer.parseInt(br.readLine());
            // 2차원 배열 초기화
            int[][] arr = new int[N][N];
            for(int i=0; i<N; i++) {
                String[] inputs = br.readLine().split(" ");
                for(int j=0; j<N; j++) {
                    arr[i][j] = Integer.parseInt(inputs[j]);
                }
            }

            int[][] dp = new int[N][N];
            dp[0][0] = arr[0][0];

            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{0, 0});
            while(!queue.isEmpty()) {
                int[] cur = queue.poll();

                for(int i=0; i<2; i++) {
                    int ny = cur[0] + dy[i];
                    int nx = cur[1] + dx[i];

                    if(ny < N && nx < N) {
                        if(dp[ny][nx] != 0) {
                            dp[ny][nx] = Math.min(dp[ny][nx], dp[cur[0]][cur[1]] + arr[ny][nx]);
                        } else {
                            dp[ny][nx] = dp[cur[0]][cur[1]] + arr[ny][nx];
                        }

                        queue.add(new int[]{ny, nx});
                    }
                }
            }
            System.out.println(dp[N-1][N-1]);
        }
    }
}
