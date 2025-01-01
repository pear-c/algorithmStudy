package CodingTest.Chap10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Chap10_3 {
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

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int[] parent = new int[N+1];

        // 모든 간선 담을 리스트
        ArrayList<Integer[]> edges = new ArrayList<>();
        int result = 0;

        // 부모 배열 초기화
        for(int i = 1; i <= N; i++)
            parent[i] = i;

        // 간선 정보 입력
        for(int i=0; i<M; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);
            edges.add(new Integer[]{a,b,c});
        }

        Collections.sort(edges, (o1, o2) -> o1[2] - o2[2]);

        int last = 0;
        // Kruskal
        for(Integer[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            int c = edge[2];
            if(find_parent(parent, a) != find_parent(parent, b)) {
                union_parent(parent, a, b);
                result += c;
                last = c;
            }
        }
        System.out.println(result - last);
    }
}
