package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_4396 {
    static int N;
    static char[][] bombmap, openMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력
        N = Integer.parseInt(br.readLine());
        bombmap = new char[N][N];
        // 지뢰 그래프 초기화
        for(int i=0; i<N; i++) {
            String inputLine = br.readLine();
            for(int j=0; j<N; j++) {
                bombmap[i][j] = inputLine.charAt(j);
            }
        }
        openMap = new char[N][N];
        for(int i=0; i<N; i++) {
            String inputLine = br.readLine();
            for(int j=0; j<N; j++) {
                openMap[i][j] = inputLine.charAt(j);
            }
        }

        char[][] result = new char[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(openMap[i][j] == 'x')
                    result[i][j] = (char)(checkBomb(i, j) + '0');
                else
                    result[i][j] = '.';
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                System.out.print(result[i][j]);
            }
            System.out.println();
        }
    }

    static int checkBomb(int a, int b) {
        int count = 0;
        // 상,하,좌,우
        if(a-1 >= 0 && bombmap[a-1][b] == '*') count++;
        if(a+1 < N  && bombmap[a+1][b] == '*') count++;
        if(b-1 >= 0 && bombmap[a][b-1] == '*') count++;
        if(b+1 < N  && bombmap[a][b+1] == '*') count++;
        // 대각선
        if(a-1 >= 0 && b+1 < N && bombmap[a-1][b+1] == '*') count++;
        if(a+1 < N && b+1 < N  && bombmap[a+1][b+1] == '*') count++;
        if(a+1 < N && b-1 >= 0 && bombmap[a+1][b-1] == '*') count++;
        if(a-1 >= 0 && b-1 >= 0 && bombmap[a-1][b-1] == '*') count++;

        return count;
    }
}
