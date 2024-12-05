package CodingTest.Chap09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Chap09_Dijkstra {
    static int n, m;                // 노드 수, 간선 수
    static List<List<Node>> graph;  // 그래프
    static int[] distance;          // 최단거리 배열

    static class Node implements Comparable<Node> {
        int to;
        int cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());   // 노드 수
        m = Integer.parseInt(st.nextToken());   // 간선 수
        int start = Integer.parseInt(br.readLine());    // 시작 노드

        // 그래프 초기화
        graph = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }

        // 거리 배열 초기화
        distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        // 간선 정보 입력
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
        }

        // 다익스트라 알고리즘 수행
        dijkstra(start);

        // 모든 노드로 가기 위한 최단 거리 출력
        for(int i=1; i<=n; i++) {
            // 도달할 수 없는 경우 무한이라고 출력
            if(distance[i] == Integer.MAX_VALUE)
                System.out.println("INFINITY");
            // 도달할 수 있는 경우 거리 출력
            else
                System.out.println(distance[i]);
        }
    }

    static void dijkstra(int start) {
        // PriorityQueue 생성
        PriorityQueue<Node> pq = new PriorityQueue<>();
        // 시작 노드로 가기 위한 최단 경로는 0으로 설정하여, 큐에 삽입
        pq.offer(new Node(start, 0));
        distance[start] = 0;

        while(!pq.isEmpty()) {
            // 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
            Node cur = pq.poll();
            int dist = cur.cost;
            int now = cur.to;

            // 이미 처리된 노드는 무시
            if(distance[now] < dist) continue;
            // 현재 노드와 연결된 다른 인접한 노드들 확인
            for(Node node : graph.get(now)) {
                int newCost = dist + node.cost;
                if(newCost < distance[node.to]) {
                    distance[node.to] = newCost;
                    pq.offer(new Node(node.to, newCost));
                }
            }
        }
    }
}
