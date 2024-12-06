package CodingTest.Chap09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Chap09_3 {
    static int n, m, c; // 도시 개수, 통로 개수, 시작 도시
    static List<List<Node>> graph;
    static int[] distance;

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

        n = Integer.parseInt(st.nextToken());   // 도시 개수 입력
        m = Integer.parseInt(st.nextToken());   // 통로 개수 입력
        c = Integer.parseInt(st.nextToken());   // 시작 도시 입력

        // 그래프 초기화
        graph = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }

        // 거리 배열 초기화
        distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        // 그래프 입력
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            graph.get(x).add(new Node(y, z));
        }

        dijkstra(c);

        int count = 0;
        int max_distance = 0;
        for(int d : distance) {
            if(d != Integer.MAX_VALUE) {
                count++;
                max_distance = Math.max(max_distance, d);
            }
        }

        System.out.println(count-1 + " " + max_distance);
    }
    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(start, 0));
        distance[start] = 0;

        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            int dist = cur.cost;
            int now = cur.to;

            if(distance[now] < dist) continue;
            for(Node nextNode : graph.get(now)) {
                int newCost = dist + nextNode.cost;
                if(newCost < distance[nextNode.to]) {
                    distance[nextNode.to] = newCost;
                    pq.offer(new Node(nextNode.to, newCost));
                }
            }
        }
    }
}
