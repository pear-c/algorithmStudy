package CodingTest.Chap10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Chap10_kruskal {
    static int find_parent(int[] parent, int x) {
        if(parent[x] != x)
            parent[x] = find_parent(parent, parent[x]);
        return parent[x];
    }

    static void union_parent(int[] parent, int a, int b) {
        a = find_parent(parent, a);
        b = find_parent(parent, b);
        if(a < b)
            parent[b] = a;
        else
            parent[a] = b;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 노드, 간선 개수 입력
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int[] parent = new int[v+1];

        // 모든 간선 담을 리스트, 변수
        ArrayList<Integer[]> edges = new ArrayList<>();
        int result = 0;

        // 부모 배열 초기화
        for(int i=1; i<=v; i++)
            parent[i] = i;

        // 간선 입력
        for(int i=0; i<e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges.add(new Integer[]{cost, a, b});
        }

        // 비용 기준으로 정렬
        Collections.sort(edges, (edge1, edge2) -> edge1[0] - edge2[0]);

        // Kruskal 알고리즘
        for(Integer[] edge : edges) {
            int cost = edge[0];
            int a = edge[1];
            int b = edge[2];
            // 사이클 발생하지 않는 경우에만 트리에 포함
            if(find_parent(parent, a) != find_parent(parent, b)) {
                union_parent(parent, a, b);
                result += cost;
            }
        }
        System.out.println(result);
    }
}
