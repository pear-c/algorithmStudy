package CodingTest.Chap10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Chap10_union_find {
    static int find_parent(int[] parent, int x) {
        // 루트 노드에 도달할때 까지 재귀 호출
        if(parent[x] != x)
            parent[x] = find_parent(parent, parent[x]);
        return parent[x];
    }

    // 합집합
    static void union_parent(int[] parent, int a, int b) {
        a = find_parent(parent, a);
        b = find_parent(parent, b);
        if(a < b)
            parent[b] = a;
        else
            parent[a] = b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());   // 노드 개수 입력
        int e = Integer.parseInt(st.nextToken());   // 간선 개수 입력

        // 부모 배열 초기화 (초기 상태 : 자기 자신)
        int[] parent = new int[v+1];
        for(int i=1; i<=v; i++)
            parent[i] = i;

//        // union 연산 수행
//        for(int i=0; i<e; i++) {
//            st = new StringTokenizer(br.readLine());
//            int a = Integer.parseInt(st.nextToken());
//            int b = Integer.parseInt(st.nextToken());
//            union_parent(parent, a, b);
//        }
//
//        // 각 원소 집합 출력
//        System.out.print("각 원소가 속한 집합: ");
//        for(int i=1; i<=v; i++) {
//            System.out.print(find_parent(parent, i) + " ");
//        }
//        System.out.println();
//
//        // 부모 테이블 출력
//        System.out.print("부모 테이블: ");
//        for(int i=1; i<=v; i++) {
//            System.out.print(parent[i] + " ");
//        }
        // 응용 - 사이클 판별
        boolean cycle = false;

        for(int i=0; i<e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(find_parent(parent, a) == find_parent(parent, b)) {
                cycle = true;
                break;
            }
            else {
                union_parent(parent, a, b);
            }
        }
        if(cycle)
            System.out.println("사이클 발생");
        else
            System.out.println("사이클 발생 X");
    }
}
