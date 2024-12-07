package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B_2606 {
    static boolean[] visited;
    static List[] computers;
    static int count = 0;
    static int N;
    static int M;

    static void DFS(int start) {
        if(!visited[start]) {
            visited[start] = true;
            count++;
            for(int i=0; i<computers[start].size(); i++) {
                DFS((int)computers[start].get(i));
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        computers = new List[N+1];
        for(int i=1; i<=N; i++) {
            computers[i] = new ArrayList<>();
        }
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
}
