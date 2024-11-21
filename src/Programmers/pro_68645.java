package Programmers;

public class pro_68645 {
    private static final int[] dx = {0, 1, -1};
    private static final int[] dy = {1, 0, -1};

    public int[] solution(int n) {
        int[][] triangle = new int[n][n];
        int v = 1;
        int x = 0;
        int y = 0;
        int d = 0;

        while (true) {
            triangle[y][x] = v++;
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx] != 0) {
                d = (d + 1) % 3;
                nx = x + dx[d];
                ny = y + dy[d];
                if (nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx] != 0) break;
            }
        }

        int[] answer = new int[v - 1];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++)
                answer[index++] = triangle[i][j];
        }
        return answer;
    }

//        while (true) {
//            // 아래로 이동
//            while (true) {
//                triangle[y][x] = v++;
//                if (y + 1 == n || triangle[y + 1][x] != 0) break;
//                y++;
//            }
//            if (x + 1 == n || triangle[y][x + 1] != 0) break;
//            x++;
//
//            // 오른쪽으로 이동
//            while (true) {
//                triangle[y][x] = v++;
//                if (x + 1 == n || triangle[y][x + 1] != 0) break;
//                x++;
//            }
//            if (triangle[y - 1][x - 1] != 0) break;
//            x--;
//            y--;
//
//            // 왼쪽 위로 이동
//            while (true) {
//                triangle[y][x] = v++;
//                if (triangle[y - 1][x - 1] != 0) break;
//                x--;
//                y--;
//            }
//            if (y + 1 == n || triangle[y + 1][x] != 0) break;
//            y++;
//        }
//
//        int index = 0;
//        int[] answer = new int[v-1];
//        for(int i=0; i<n; i++) {
//            for(int j=0; j<=i; j++) {
//                answer[index++] = triangle[i][j];
//            }
//        }
//        return answer;
//    }
}
