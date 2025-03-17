package CodingTest.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// DFS/BFS Q.17 - 경쟁적 전염
public class DFS_BFS_17 {
    static int N, K;
    static int S, X, Y;
    static int[][] map;
    static List<Virus> virusLocation = new ArrayList<>();
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for(int y=0; y<N; y++) {
            st = new StringTokenizer(br.readLine());
            for(int x=0; x<N; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
                if(map[y][x] != 0) {
                    virusLocation.add(new Virus(map[y][x], x, y));
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        System.out.println(findVirus());
    }

    static int findVirus() {
        int[][] temp = new int[N][N];
        for(int i=0; i<N; i++) {
            temp[i] = map[i].clone();
        }

        virusLocation.sort((o1, o2) -> o1.data - o2.data);
        Queue<Virus> queue = new LinkedList<>();
        queue.addAll(virusLocation);

        for(int i=0; i<S; i++) {
            int count = queue.size();
            while(count-- > 0) {
                Virus v = queue.poll();

                for(int d=0; d<4; d++) {
                    int nx = v.x + dx[d];
                    int ny = v.y + dy[d];

                    if(nx >= 0 && ny >= 0 && nx < N && ny < N && temp[ny][nx] == 0) {
                        temp[ny][nx] = v.data;
                        queue.add(new Virus(v.data, nx, ny));
                    }
                }
            }
        }

        return temp[X-1][Y-1];
    }

    static class Virus {
        int data;
        int x, y;

        public Virus(int data, int x, int y) {
            this.data = data;
            this.x = x;
            this.y = y;
        }
    }
}
