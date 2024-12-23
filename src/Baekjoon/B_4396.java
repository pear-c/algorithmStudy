package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_4396 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int n = Integer.parseInt(br.readLine());
        char[][] bombMap = new char[n][n];
        char[][] opendMap = new char[n][n];
        boolean checkBomb = false;
        // 지뢰 필드 입력
        for(int i=0; i<n; i++) {
            String s = br.readLine();
            for(int j=0; j<n; j++) {
                bombMap[i][j] = s.charAt(j);
            }
        }
        // 오픈된 필드 입력
        for(int i=0; i<n; i++) {
            String s = br.readLine();
            for(int j=0; j<n; j++) {
                opendMap[i][j] = s.charAt(j);
            }
        }

        char[][] result = new char[n][n];
        for(int i=0; i<n; i++)
            Arrays.fill(result[i], ' ');

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(opendMap[i][j] == 'x') {
                    if(bombMap[i][j] == '*')
                        checkBomb = true;
                    else
                        result[i][j] = (char)(countBomb(bombMap, i, j) + '0');
                }
                else
                    result[i][j] = '.';
            }
        }

        // 지뢰 터졌으면 모든 지뢰 표시
        if(checkBomb) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(bombMap[i][j] == '*')
                        result[i][j] = '*';
                }
            }
        }

        // 결과 출력
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                System.out.print(result[i][j]);
            }
            System.out.println();
        }
    }

    static int countBomb(char[][] bombMap, int x, int y) {
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        int count = 0;

        for(int i=0; i<8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < bombMap.length && ny < bombMap.length && bombMap[nx][ny] == '*')
                count++;
        }
        return count;
    }
}