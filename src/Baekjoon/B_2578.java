package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class B_2578 {
    final static int N = 5;

    static class Point {
        int x;
        int y;
        boolean check;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
            check = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 빙고판 입력
        HashMap<Integer, Point> bingo = new HashMap<>();
        for(int i=0; i<N; i++) {
            String[] inputs = br.readLine().split(" ");
            for(int j=0; j<N; j++) {
                bingo.put(Integer.parseInt(inputs[j]), new Point(i, j));
            }
        }

        boolean[][] bingoCheck = new boolean[N][N];

        int result = 0;
        A: for(int i=0; i<N; i++) {
            String[] numbers = br.readLine().split(" ");
            for(int j=0; j<N; j++) {
                int num = Integer.parseInt(numbers[j]);
                int x = bingo.get(num).x;
                int y = bingo.get(num).y;
                bingoCheck[x][y] = true;
                result++;
                if(check(bingoCheck))
                    break A;
            }
        }
        System.out.println(result);
    }

    static boolean check(boolean[][] bingoCheck) {
        int count = 0;
        int sum = 0;
        // 행 체크
        for(int i=0; i<N; i++) {
            sum = 0;
            for(int j=0; j<N; j++) {
                if(bingoCheck[i][j]) {
                    sum++;
                }
            }
            if(sum == 5)
                count++;
        }

        // 열 체크
        for(int i=0; i<N; i++) {
            sum = 0;
            for(int j=0; j<N; j++) {
                if(bingoCheck[j][i]) {
                    sum++;
                }
            }
            if(sum == 5)
                count++;
        }

        // 하향 대각선
        sum = 0;
        for(int i=0; i<N; i++) {
            if(bingoCheck[i][i])
                sum++;
        }
        if(sum == 5)
            count++;

        sum = 0;
        for(int i=0; i<N; i++) {
            if(bingoCheck[i][4-i])
                sum++;
        }
        if(sum == 5)
            count++;

        if(count >= 3)
            return true;

        return false;
    }
}
