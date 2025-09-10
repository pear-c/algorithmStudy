package CodingTest.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_2667 {

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static List<Integer> list = new ArrayList<>();

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void bfs(Pos pos) {
        Queue<Pos> queue = new LinkedList<>();
        queue.add(pos);
        visited[pos.y][pos.x] = true;

        int count = 0;
        while (!queue.isEmpty()) {
            Pos cur = queue.poll();
            count++;

            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[ny][nx] && map[ny][nx] == 1) {
                    queue.add(new Pos(nx, ny));
                    visited[ny][nx] = true;
                }
            }
        }

        list.add(count);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            for(int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        for(int y = 0; y < N; y++) {
            for(int x = 0; x < N; x++) {
                if(map[y][x] == 1 && !visited[y][x]) {
                    bfs(new Pos(x, y));
                }
            }
        }

        System.out.println(list.size());
        Collections.sort(list);
        for(int i : list) {
            System.out.println(i);
        }
    }
}
