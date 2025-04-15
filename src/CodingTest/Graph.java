package CodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Graph {
    static int find_parent(int[] parent, int x) {
        if(parent[x] != x) {
            parent[x] = find_parent(parent, parent[x]);
        }
        return parent[x];
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N, M 그래프 초기화
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] graph = new int[N+1][N+1];
        for(int i=1; i<=N; i++) {
            String[] inputs = br.readLine().split(" ");
            for(int j=1; j<=N; j++) {
                graph[i][j] = Integer.parseInt(inputs[j]);
            }
        }
        // 부모 노드 초기화
        int[] pArr = new int[N+1];
        for(int i=1; i<=N; i++) {
            pArr[i] = i;
        }

        // 부모 노드 체크
        for(int i=0; i<M; i++) {

        }



    }
}
