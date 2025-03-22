package CodingTest.DFS_BFS;

import java.io.IOException;
import java.util.*;

// DFS/BFS Q.21 - 인구 이동
public class DFS_BFS_21 {
    static int N, L, R;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int count = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        L = sc.nextInt();
        R = sc.nextInt();
        map = new int[N][N];
        for(int j=0; j<N; j++) {
            for(int i=0; i<N; i++) {
                map[j][i] = sc.nextInt();
            }
        }

        while(true) {
            visited = new boolean[N][N];
            boolean moved = false;

            for(int j=0; j<N; j++) {
                for(int i=0; i<N; i++) {
                    if(!visited[j][i]) {
                        if(bfs(j, i)) moved = true;
                    }
                }
            }

            if(!moved) break;
            count++;
        }
        System.out.println(count);
    }

    static boolean bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> crewList = new ArrayList<>();
        queue.add(new int[]{y, x});
        crewList.add(new int[]{y, x});
        visited[y][x] = true;
        int sum = map[y][x];

        while(!queue.isEmpty()) {
            int[] pos = queue.poll();

            for(int d=0; d<4; d++) {
                int ny = dy[d] + pos[0];
                int nx = dx[d] + pos[1];

                if(nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[ny][nx]) {
                    int sub = Math.abs(map[ny][nx] - map[pos[0]][pos[1]]);

                    if(sub >= L && sub <= R) {
                        queue.add(new int[]{ny, nx});
                        crewList.add(new int[]{ny, nx});
                        visited[ny][nx] = true;
                        sum += map[ny][nx];
                    }
                }
            }
        }

        if(crewList.size() > 1) {
            int avg = sum / crewList.size();
            for(int[] pos : crewList) {
                map[pos[0]][pos[1]] = avg;
            }
            return true;
        }
        return false;
    }
}
