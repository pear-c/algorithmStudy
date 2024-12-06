package CodingTest.Chap09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Chap09_2 {
    static int N, M;    // 회사, 경로 개수
    static int[][] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   // 회사 개수
        M = Integer.parseInt(st.nextToken());   // 경로 개수

        // 그래프 초기화
        graph = new int[N+1][N+1];
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(i == j)
                    graph[i][j] = 0;
                else
                    graph[i][j] = Integer.MAX_VALUE;
            }
        }

        // 그래프 입력
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 양방향
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        // X, K 입력
        st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 플로이드 워셜 알고리즘
        for(int i=1; i<=N; i++) {
            for(int a=1; a<=N; a++) {
                for(int b=1; b<=N; b++) {
                    // Integer.MAX_VALUE + 정수를 했을 때, int 값 벗어남 방지 삼항연산자 사용
                    graph[a][b] = Math.min(graph[a][b], (graph[a][i] == Integer.MAX_VALUE || graph[i][b] == Integer.MAX_VALUE)
                            ? Integer.MAX_VALUE : graph[a][i] + graph[i][b]);
                }
            }
        }

        int distance = graph[1][K] + graph[K][X];
        System.out.println(distance >= Integer.MAX_VALUE ? -1 : distance);
    }
}
