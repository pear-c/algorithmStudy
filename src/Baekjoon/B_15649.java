package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_15649 {
    static int N, M;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // N, M 입력
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        visited = new boolean[N + 1];

        dfs(0);
    }

    static void dfs(int num) {
        // 문자열 크기가 M이랑 같으면 재귀 종료
        if(sb.length() == M) {
            // 숫자 사이 공백 추가
            for(int i=0; i<sb.length(); i++)
                System.out.print(sb.charAt(i) + " ");
            System.out.println();
            return;
        }

        for(int i=1; i<=N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                sb.append(i);

                dfs(num+1);
                // 백 트래킹
                visited[i] = false;
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}
