package CodingTest.Chap10;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Chap10_2 {
    // 부모 탐색
    static int find_parent(int[] parent, int x) {
        if(parent[x] != x)
            parent[x] = find_parent(parent, parent[x]);
        return parent[x];
    }

    // 합집합
    static void union_parent(int[] parent, int x, int y) {
        x = find_parent(parent, x);
        y = find_parent(parent, y);
        if(x < y)
            parent[y] = x;
        else
            parent[x] = y;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // N, M 입력
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);

        // 부모 배열 초기화
        int[] parent = new int[N+1];
        for(int i=0; i<=N; i++) {
            parent[i] = i;
        }

        while(M-- > 0) {
            inputs = br.readLine().split(" ");
            int command = Integer.parseInt(inputs[0]);
            int a = Integer.parseInt(inputs[1]);
            int b = Integer.parseInt(inputs[2]);

            if(command == 0) {
                union_parent(parent, a, b);
            }
            else if(command == 1) {
                if(find_parent(parent, a) == find_parent(parent, b)) {
                    System.out.println("YES");
                }
                else {
                    System.out.println("NO");
                }
            }
        }
    }
}
