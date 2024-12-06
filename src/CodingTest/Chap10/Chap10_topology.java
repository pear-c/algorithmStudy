package CodingTest.Chap10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Chap10_topology {
    static int v, e;
    static int[] indegree;
    static List<List<Integer>> graph;

    // 위상 정렬
    static void topology_sort() {
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> q = new ArrayDeque<>();

        // 초기 진입차수 0인 노드 삽입
        for(int i=1; i<=v; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        while(!q.isEmpty()) {
            // 큐에서 원소 꺼내기
            int now = q.poll();
            result.add(now);
            // 해당 노드와 연결된 노드 진입차수 -1
            for(int i : graph.get(now)) {
                indegree[i]--;
                // 새롭게 진입차수가 0이 되는 노드 큐에 삽입
                if(indegree[i] == 0) {
                    q.add(i);
                }
            }
        }
        // 결과 출력
        for(int i : result) {
            System.out.print(i + " ");
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 노드, 간선 개수 입력
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        // 진입 차수 배열
        indegree = new int[v+1];
        // 연결 리스트
        graph = new ArrayList<>();
        for(int i=0; i<=v; i++)
            graph.add(new ArrayList<>());

        // 그래프 입력
        for(int i=0; i<e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            indegree[b]++;
        }

        // 위상 정렬
        topology_sort();
    }
}
