package CodingTest.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 1932 : 정수삼각형
public class DP_32 {
    static int N;
    static int[][] triangle;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        triangle = new int[N][N];
        for(int i=0; i<N; i++) {
            String[] inputs = br.readLine().split(" ");
            for(int j=0; j<inputs.length; j++) {
                triangle[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        int[][] dp = new int[N][N];
        dp[0][0] = triangle[0][0];

        int leftUp = 0;
        int rightUp = 0;
        for(int i=1; i<N; i++) {
            for(int j=0; j<=i; j++) {
                if(j == 0) {
                    leftUp = 0;
                } else {
                    leftUp = dp[i-1][j-1];
                }
                if(j == i) {
                    rightUp = 0;
                } else {
                    rightUp = dp[i-1][j];
                }
                dp[i][j] = triangle[i][j] + Math.max(leftUp, rightUp);
            }
        }
        int result = 0;
        for(int i=0; i<N; i++) {
            result = Math.max(result, dp[N-1][i]);
        }
        System.out.println(result);
    }
}
