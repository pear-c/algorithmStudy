package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, V;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    public static void dfs(int v) {
        visited[v] = true;
        System.out.print(v + " ");

        for(int next : graph.get(v)) {
            if(!visited[next]) {
                dfs(next);
            }
        }
    }

    public static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        visited[v] = true;
        q.add(v);

        while(!q.isEmpty()) {
            int cur = q.poll();
            System.out.print(cur + " ");

            for(int next : graph.get(cur)) {
                if(!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        for(int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[N+1];

        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for(int i=1; i<=N; i++) {
            Collections.sort(graph.get(i));
        }

        dfs(V);
        System.out.println();
        visited = new boolean[N+1];
        bfs(V);
    }
}
