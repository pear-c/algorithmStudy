package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B_2606 {
    static int N, M;
    static boolean[] visited;
    static List[] computers;
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // N, M 입력
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        // 컴퓨터 초기화
        visited = new boolean[N+1];
        computers = new List[N+1];
        for(int i=1; i<=N; i++) {
            computers[i] = new ArrayList<>();
        }
        // 컴퓨터 정보 입력
        for(int i=1; i<=M; i++) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            computers[a].add(b);
            computers[b].add(a);
        }

        DFS(1);

        System.out.println(count-1);
    }
    static void DFS(int start) {
        // 방문 하지 않은 노드 탐색
        if(!visited[start]) {
            visited[start] = true;
            count++;
            for(int i=0; i<computers[start].size(); i++) {
                DFS((int)computers[start].get(i));
            }
        }
    }
}
