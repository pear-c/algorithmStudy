package CodingTest.ShortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 11404 - 플로이드
public class ShortPath_37 {
    static int n, m;
    static int INF = 100000001;
    static int graph[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 초기화
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        graph = new int[n+1][n+1];
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(i != j) graph[i][j] = INF;
            }
        }

        while(m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[a][b] = Math.min(graph[a][b], cost);
        }

        // 플로이드
        for(int i=1; i<=n; i++) {
            for(int a=1; a<=n; a++) {
                for(int b=1; b<=n; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][i] + graph[i][b]);
                }
            }
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(graph[i][j] == INF) System.out.print("0 ");
                else System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}
