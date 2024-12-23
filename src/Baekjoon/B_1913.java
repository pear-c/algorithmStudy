package Baekjoon;

import java.io.IOException;
import java.util.Scanner;

public class B_1913 {
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] map;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        // N, K 입력
       int n = sc.nextInt();
       int k = sc.nextInt();
       map = new int[n][n];
       int startX = 0;
       int startY = 0;

       makeMap(n);

       for(int i=0; i<map.length; i++) {
           for(int j=0; j<map.length; j++) {
               sb.append(map[i][j]).append(" ");
               if(map[i][j] == k) {
                   startX = i;
                   startY = j;
               }
           }
           sb.append("\n");
       }
       sb.append(startX+1).append(" ").append(startY+1);
       System.out.println(sb);
    }

    static void makeMap(int n) {
        int x = 0;
        int y = 0;
        int count = n*n;
        int d = 0;

        while (true) {
            if(count == 0)
                break;

            map[y][x] = count--;
            int ny = y + dy[d];
            int nx = x + dx[d];
            int nd = setDirection(d, n, ny, nx);

            if(nd != d) {
                y += dy[nd];
                x += dx[nd];
                d = nd;
            }
            else {
                y = ny;
                x = nx;
            }
        }
    }

    static int setDirection(int d, int n, int ny, int nx) {
        if(ny >= n || nx >= n || ny < 0 || nx < 0) {
            d = (d+1) % 4;
        }
        else if(map[ny][nx] != 0) {
            d = (d+1) % 4;
        }
        return d;
    }
}
