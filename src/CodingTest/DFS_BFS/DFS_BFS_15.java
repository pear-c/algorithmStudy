package CodingTest.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// DFS/BFS Q.15 - 특정 거리의 도시 찾기
/// DFS 문제
public class DFS_BFS_15 {
    static int N, M, K, X;
    static boolean[] visited;
    static List<Integer>[] town;
    static int[] minDist;
    static int count = 0;

    static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        minDist[start] = count;

        while(!queue.isEmpty()) {
            int v = queue.poll();
            int min = minDist[v] + 1;
            for(int i : town[v]) {
                if(!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    minDist[i] = min;
                }
            }
        }
        for(int i=0; i<minDist.length; i++) {
            if(minDist[i] == K) {
                System.out.println(i);
                count++;
            }
        }
        if(count < 1) {
            System.out.println(-1);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);    // 도시 개수
        M = Integer.parseInt(inputs[1]);    // 도로 개수
        K = Integer.parseInt(inputs[2]);    // 목표 거리
        X = Integer.parseInt(inputs[3]);    // 출발 도시

        // 도시 정보 초기화
        town = new List[N+1];
        for(int i=1; i<=N; i++) {
            town[i] = new ArrayList<>();
        }
        // 방문 배열 초기화
        visited = new boolean[N+1];
        // 최단 거리 배열 초기화
        minDist = new int[N+1];

        while(M-- > 0) {
            // 도시 정보 입력
            inputs = br.readLine().split(" ");
            int start = Integer.parseInt(inputs[0]);
            int end = Integer.parseInt(inputs[1]);

            town[start].add(end);
        }

        BFS(X);
    }
}
