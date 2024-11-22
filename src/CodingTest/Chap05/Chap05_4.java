package CodingTest.Chap05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Chap05_4 {
    static int N;
    static int M;
    static int[][] graph;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Pos {
        int x, y;
        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // N x M 입력
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 그래프 설정
        graph = new int[N+1][M+1];
        for(int i=1; i<=N; i++) {
            String line = br.readLine();
            for(int j=1; j<=M; j++) {
                graph[i][j] = line.charAt(j-1) - '0';
            }
        }

        System.out.println(BFS(1,1));
    }
    private static int BFS(int x, int y) {
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(x, y));

        while(!q.isEmpty()) {
            Pos cur = q.poll();
            for(int i=0; i<4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                // 범위 벗어나면 무시
                if(nx < 1 || ny < 1 || nx > N || ny > M) continue;
                // 괴물인 경우 무시
                if(graph[nx][ny] == 0) continue;
                // 해당 노드를 처음 방문하는 경우에만 최단 거리 기록
                if(graph[nx][ny] == 1) {
                    graph[nx][ny] = graph[cur.x][cur.y] + 1;
                    q.add(new Pos(nx, ny));
                }
            }
        }
        return graph[N][M];
    }
}
