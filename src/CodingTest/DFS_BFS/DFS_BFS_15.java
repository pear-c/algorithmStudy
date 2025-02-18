package CodingTest.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

// DFS/BFS Q.15 - 특정 거리의 도시 찾기
/// DFS 문제
public class DFS_BFS_15 {
    static int N, M, K, X;
    static List<Integer>[] graph;
    static boolean[] visited;
    static int time;
    static int[] times;

    static void DFS(int i, List<Integer>[] graph) {
        visited[i] = true;

        for(int v: graph[i]) {
            if (!visited[v]) {
                time++;
                DFS(v, graph);
                times[v] = time;
                time = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);
        X = Integer.parseInt(input[3]);

        graph = new List[N + 1];
        visited = new boolean[N + 1];
        times = new int[N + 1];
        for(int i = 1; i <= N; i++){
            graph[i] = new LinkedList<>();
        }
        for(int i=0; i<M; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            graph[a].add(b);
        }

        DFS(X, graph);
    }
}
