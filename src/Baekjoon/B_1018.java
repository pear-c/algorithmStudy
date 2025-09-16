package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1018 {

    static boolean[][] arr;
    static int res =  Integer.MAX_VALUE;

    static void find(int x, int y) {
        int end_x = x + 8;
        int end_y = y + 8;
        int count = 0;

        boolean first = arr[x][y];

        for(int i=x; i<end_x; i++){
            for(int j=y; j<end_y; j++){
                if(arr[i][j] != first){
                    count++;
                }

                first = (!first);
            }
            first = !first;
        }

        count = Math.min(count, 64 - count);
        res = Math.min(res, count);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new boolean[N][M];

        for(int i=0; i<N; i++) {
            String line = br.readLine();
            for(int j=0; j<M; j++) {
                if(line.charAt(j) == 'W') {
                    arr[i][j] = true;
                } else {
                    arr[i][j] = false;
                }
            }
        }

        int maxRow = N - 7;
        int maxCol = M - 7;

        for(int i=0; i<maxRow; i++) {
            for(int j=0; j<maxCol; j++) {
                find(i, j);
            }
        }

        System.out.println(res);
    }
}
