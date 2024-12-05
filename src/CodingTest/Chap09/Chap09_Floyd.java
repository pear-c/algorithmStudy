package CodingTest.Chap09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Chap09_Floyd {
    static int n, m;
    static int[][] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine()); // 노드 수
        m = Integer.parseInt(br.readLine()); // 간선 수
        graph = new int[n+1][n+1];  // 그래프 초기화 (초기값 : 무한 / 자기 자신 : 0)
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(i == j)
                    graph[i][j] = 0;
                else
                    graph[i][j] = Integer.MAX_VALUE;
            }
        }
        // 간선 정보 입력
        for(int i=0; i<m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a][b] = c;
        }

        // 플로이드 워셜 알고리즘
        for(int i=1; i<=n; i++) {
            for(int a=1; a<=n; a++) {
                for(int b=1; b<=n; b++) {
                    // Integer.MAX_VALUE + 정수를 했을 때, int 값 벗어남 방지 삼항연산자 사용
                    graph[a][b] = Math.min(graph[a][b], (graph[a][i] == Integer.MAX_VALUE || graph[i][b] == Integer.MAX_VALUE)
                                                        ? Integer.MAX_VALUE : graph[a][i] + graph[i][b]);
                }
            }
        }

        // 결과 출력
        for(int a=1; a<=n; a++) {
            for(int b=1; b<=n; b++) {
                System.out.print(graph[a][b] != Integer.MAX_VALUE ? graph[a][b] : "INFINITY");
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
