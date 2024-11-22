package CodingTest.Chap05;

import java.util.Deque;
import java.util.LinkedList;

public class Chap5_DFS_BFS {
    private static void DFS(int[][] graph, int v, boolean[] visited) {
        // 현재 노드 방문 처리
        visited[v] = true;
        System.out.print(v + " ");
        // 현재 노드와 연결된 다른 노드 재귀 방문
        for(int i : graph[v]) {
            if (!visited[i]) {
                DFS(graph, i, visited);
            }
        }
    }

    private static void BFS(int[][] graph, int start, boolean[] visited) {
        // 큐 사용
        Deque<Integer> queue = new LinkedList<>();
        queue.add(start);
        // 현재 노드 방문 처리
        visited[start] = true;
        // 큐가 빌 때까지 반복
        while(!queue.isEmpty()) {
            // 큐에서 하나의 원소를 뽑아 출력
            int v = queue.poll();
            System.out.print(v + " ");
            // 해당 원소와 연결된, 아직 방문하지 않은 원소들을 큐에 삽입
            for(int i : graph[v]) {
                if (!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        // graph 설정
        int[][] graph = {
                {},
                {2, 3, 8},
                {1, 7},
                {1, 4, 5},
                {3, 5},
                {3, 4},
                {7},
                {2, 6, 8},
                {1, 7}
        };

        // 방문 정보 저장 배열
        boolean[] visited = new boolean[graph.length];

        BFS(graph, 1, visited);
    }
}
